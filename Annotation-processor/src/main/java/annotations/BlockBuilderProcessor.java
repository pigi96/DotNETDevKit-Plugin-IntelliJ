package annotations;

import com.google.auto.service.AutoService;
import utils.SimpleGenericTypeNameVisitor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@AutoService(Processor.class)
public class BlockBuilderProcessor extends AbstractProcessor {
    private ProcessingEnvironment processingEnvironment;

    private List<String> typeNames;

    private Set<String> requiredImports = new HashSet<>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.processingEnvironment = processingEnvironment;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(BlockBuilder.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                typeNames = new ArrayList<>();
                CodeBuilder builder = new CodeBuilder();
                String packageName = ((TypeElement) element).getQualifiedName().toString();
                String className = element.getSimpleName().toString();
                String classNameBuilderImpl = className + "Builder";
                builder.append("package com.olvins.kit;\n")
                        .emptyLine()
                        .append("import java.util.List;")
                        .emptyLine()
                        .append("/**")
                        .append(" * Class has been generated with the use of @BlockBuilder annotation, for custom or more advanced")
                        .append(" * usage please refer to extending the Block class yourself (in this case look at the")
                        .append(" * generated classes and follow the pattern)")
                        .append(" */")
                        .append("public class " + classNameBuilderImpl + " extends AbstractBuilder<" + className + "> {")
                        .append("\tprivate " + classNameBuilderImpl + "() {")
                        .append("\t\t// Disabled access to class, can only be used through static methods")
                        .append("\t}")
                        .emptyLine()
                        .append("\tpublic static " + classNameBuilderImpl + " start() {")
                        .append("\t\treturn new " + classNameBuilderImpl + "();")
                        .append("\t}")
                        .emptyLine();

                processClass((TypeElement) element, builder, className, classNameBuilderImpl);
                generateBuildOverride(builder, className);

                builder.append("}");

                addRequiredImports(builder, ((TypeElement) element).getQualifiedName().toString());

                try {
                    JavaFileObject builderFile = processingEnv.getFiler().createSourceFile("com.olvins.kit.dotnetdevkit.blocks." + classNameBuilderImpl);

                    try (BufferedWriter writer = new BufferedWriter(builderFile.openWriter())) {
                        writer.write(builder.generate());
                    }
                } catch (Exception ex) {
                    // dont care for now
                }
            }
        }
        return true;
    }

    private void generateConstructors(CodeBuilder builder, String className, String classNameBuilderImpl, List<? extends VariableElement> parameters) {
        // Basic fast builder constructor
        CodeBuilder constructorParameters = CodeBuilder.quickBuilt(parameters.stream().map(parameter -> getSimpleTypeNameWithGenerics(parameter.asType()) + " " + parameter.getSimpleName().toString()).collect(Collectors.toList()));

        builder.append("\tpublic static " + className + " create(" + constructorParameters.generateParams() + ") {")
                .append("\t\treturn start()");

        CodeBuilder builderParameters = CodeBuilder.quickBuilt(
                parameters.stream().map(parameter -> "\t\t\t\t." + parameter.getSimpleName().toString() + "(" + parameter.getSimpleName().toString() + ")").collect(Collectors.toList())
        );

        builder.append(builderParameters.generate())
                .append("\t\t\t\t.build();")
                .append("\t}")
                .emptyLine();

        boolean constructorCanBeSimplified = false;
        List<ComplexConstructorVariable> variables = new ArrayList<>();
        // Simple constructor if it contains elements of the ISimpleBlock interface
        for (var parameter : parameters) {
            String classNameToCheck = parameter.asType().toString();
            TypeElement classTypeElement = processingEnvironment.getElementUtils().getTypeElement(classNameToCheck);
            TypeElement interfaceTypeElement = processingEnvironment.getElementUtils().getTypeElement("com.olvins.kit.dotnetdevkit.blocks.controls.ISimpleBlock");

            boolean implementsInterface = false;
            TypeMirror typeMirror = parameter.asType();

            if (typeMirror instanceof DeclaredType) {
                DeclaredType declaredType = (DeclaredType) typeMirror;
                Element element = declaredType.asElement();

                try {
                    if (element instanceof TypeElement) {
                        for (TypeMirror implementedInterface : classTypeElement.getInterfaces()) {
                            if (processingEnvironment.getTypeUtils().isSameType(implementedInterface, interfaceTypeElement.asType())) {
                                implementsInterface = true;
                                constructorCanBeSimplified = true;
                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                    // Ignore
                }
            }

            if (implementsInterface) {
                variables.add(new ComplexConstructorVariable("String", getSimpleTypeNameWithGenerics(parameter.asType()), parameter.getSimpleName().toString(), true));
            } else {
                variables.add(new ComplexConstructorVariable(getSimpleTypeNameWithGenerics(parameter.asType()), parameter.getSimpleName().toString(), false));
            }
        }

        // Basic fast builder constructor
        if (constructorCanBeSimplified) {
            CodeBuilder simpleConstructorParameters = CodeBuilder.quickBuilt(
                    variables.stream().map(ComplexConstructorVariable::getVariable).collect(Collectors.toList())
            );

            builder.append("\tpublic static " + className + " create(" + simpleConstructorParameters.generateParams() + ") {")
                    .append("\t\treturn start()");

            CodeBuilder complexConstructorInitializations = CodeBuilder.quickBuilt(
                    variables.stream().map(variable -> "\t\t\t\t." + variable.builderComplexAddition()).collect(Collectors.toList())
            );

            builder.append(complexConstructorInitializations.generate())
                    .append("\t\t\t\t.build();")
                    .append("\t}");
        }
    }

    private void processClass(TypeElement classElement, CodeBuilder builder, String className, String classNameBuilderImpl) {
        for (Element enclosed : classElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.CONSTRUCTOR) {
                generateConstructors(builder, className, classNameBuilderImpl, ((ExecutableElement) enclosed).getParameters());
                for (VariableElement parameter : ((ExecutableElement) enclosed).getParameters()) {
                    generateBuilderMethod(parameter, builder, className, classNameBuilderImpl);
                }
            }
        }
    }

    private void generateBuilderMethod(VariableElement parameter, CodeBuilder builder, String className, String classNameBuilderImpl) {
        String typeName = getSimpleTypeNameWithGenerics(parameter.asType());
        typeNames.add(typeName);
        builder.append("\tpublic " + classNameBuilderImpl + " " + parameter.getSimpleName() + "(" + typeName + " " + parameter.getSimpleName() + ") {")
                .append("\t\tsetField(\"" + typeName + "\", " + parameter.getSimpleName() + ");")
                .append("\t\treturn this;")
                .append("\t}")
                .emptyLine();
    }

    private void generateBuildOverride(CodeBuilder builder, String className) {
        CodeBuilder validatorParameters = CodeBuilder.quickBuilt(
                typeNames.stream().map(typeName -> "\"" + typeName + "\"").collect(Collectors.toList())
        );

        builder.append("\t@Override")
                .append("\tpublic " + className + " build() {")
                .append("\t\tvalidate(" + validatorParameters.generateParams() + ");")
                .append("\t\treturn new " + className + "(");

        CodeBuilder constructorParameters = CodeBuilder.quickBuilt(
                typeNames.stream().map(typeName -> "\t\t\t\t(" + typeName + ") fields.get(\"" + typeName + "\")").collect(Collectors.toList())
        );

        builder.append(constructorParameters.generateLineParams());

        builder.append("\t\t);")
                .append("\t}");
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(BlockBuilder.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private String getSimpleTypeNameWithGenerics(TypeMirror typeMirror) {
        String fullTypeName = typeMirror.toString();
        return removePackageNames(fullTypeName);
    }

    private String removePackageNames(String fullTypeName) {
        if (!fullTypeName.contains("<")) {
            requiredImports.add(fullTypeName); // TODO - fix for more complex operations
        }
        StringBuilder result = new StringBuilder();
        int start = 0;
        int bracketDepth = 0;

        for (int i = 0; i < fullTypeName.length(); i++) {
            char ch = fullTypeName.charAt(i);

            if (ch == '<') {
                bracketDepth++;
                if (bracketDepth == 1) {
                    result.append(extractSimpleName(fullTypeName.substring(start, i))).append(ch);
                    start = i + 1;
                }
            } else if (ch == '>') {
                bracketDepth--;
                if (bracketDepth == 0) {
                    result.append(removePackageNames(fullTypeName.substring(start, i))).append(ch);
                    start = i + 1;
                }
            } else if (ch == ',' && bracketDepth == 1) {
                result.append(removePackageNames(fullTypeName.substring(start, i))).append(", ");
                start = i + 2;
            }
        }

        if (start < fullTypeName.length()) {
            result.append(extractSimpleName(fullTypeName.substring(start)));
        }

        return result.toString();
    }

    private String extractSimpleName(String typeName) {
        int lastDotIndex = typeName.lastIndexOf('.');
        return (lastDotIndex == -1) ? typeName : typeName.substring(lastDotIndex + 1);
    }

    private void addRequiredImports(CodeBuilder builder, String classImport) {
        CodeBuilder importsBuilder = CodeBuilder.quickBuilt(requiredImports.stream().map(value -> "import " + value + ";").collect(Collectors.toList()));
        importsBuilder.add(0, Arrays.asList(
                "import com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder;",
                "import " + classImport + ";")
        );

        var contains = importsBuilder.getCodeLines().indexOf("import T;");
        if (contains != -1) {
            importsBuilder.getCodeLines().remove(contains);
        }

        builder.add(1, importsBuilder.getCodeLines());
    }
}
