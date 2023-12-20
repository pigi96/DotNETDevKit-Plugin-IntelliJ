package annotations;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AutoService(Processor.class)
public class EntryProcessor extends AbstractProcessor {
    private ProcessingEnvironment processingEnvironment;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.processingEnvironment = processingEnvironment;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(BlockBuilder.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        generateBuilderClasses(annotations, roundEnvironment);
        return true;
    }

    private void generateBuilderClasses(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        Set<Pair> blocBuilderClasses = new HashSet<>();

        // Create all required block builder classes
        for (Element element : roundEnvironment.getElementsAnnotatedWith(BlockBuilder.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                String className = element.getSimpleName().toString();
                BaseProcessor blockBuilderProcessor = new BlockBuilderProcessor(className, processingEnvironment, element);
                blockBuilderProcessor.process();
                blockBuilderProcessor.createClass();

                blocBuilderClasses.add(new Pair(blockBuilderProcessor.getGenClassName(), String.format("%s.%s", blockBuilderProcessor.getGenClassLocation(), blockBuilderProcessor.getGenClassName()), Type.BUILDER));
            }
        }

        // Create a class that collects all builders and any utils that would be needed for the frontend part of the application
        BaseProcessor blockCollectorProcessor = new BlockCollectorProcessor(processingEnvironment, null);
        blockCollectorProcessor.addClassImports(blocBuilderClasses);
        blockCollectorProcessor.process();
        blockCollectorProcessor.createClass();
    }
}
