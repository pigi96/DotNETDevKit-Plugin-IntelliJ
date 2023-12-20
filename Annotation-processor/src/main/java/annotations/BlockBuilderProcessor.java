package annotations;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlockBuilderProcessor extends BaseProcessor {
    private List<String> typeNames;

    private static final String BUILDER_PACKAGE_NAME = "com.olvins.kit";
    private static final String BUILDER_IMPL_NAME = "Builder";
    private static final String SIMPLE_BLOCK_INTERFACE = "com.olvins.kit.dotnetdevkit.blocks.controls.ISimpleBlock";
    private static final String ABSTRACT_BLOCK_SUPERCLASS = "com.olvins.kit.dotnetdevkit.blocks.controls.Block";

    public BlockBuilderProcessor(String className, ProcessingEnvironment processingEnvironment, Element element) {
        super(className, BUILDER_PACKAGE_NAME, String.format("%s%s", className, BUILDER_IMPL_NAME), processingEnvironment, element);
    }

    @Override
    public boolean process() {
        typeNames = new ArrayList<>();
        String className = element.getSimpleName().toString();
        String classNameBuilderImpl = className + "Builder";

        addClassImports("List", "java.util.List", Type.GENERAL);
        addClassImports("Map", "java.util.Map", Type.GENERAL);
        addClassImports("LinkedHashMap", "java.util.LinkedHashMap", Type.GENERAL);
        addClassImports("AbstractBuilder", "com.olvins.kit.dotnetdevkit.blocks.controls.AbstractBuilder", Type.GENERAL);
        addClassImports(className, ((TypeElement) element).getQualifiedName().toString(), Type.GENERAL);

        builder.append("public class %s extends AbstractBuilder<%s> {", classNameBuilderImpl, className)
                .append("\tprivate %s() {", classNameBuilderImpl)
                .append("\t\t// Disabled access to class, can only be used through static methods")
                .append("\t}")
                .emptyLine()
                .append("\tpublic static %s start() {", classNameBuilderImpl)
                .append("\t\treturn new %s();", classNameBuilderImpl)
                .append("\t}")
                .emptyLine();

        processClass((TypeElement) element, builder, className, classNameBuilderImpl);
        builder.append(generateBuildOverride(className));

        builder.append("}");

        return true;
    }

    private void processClass(TypeElement classElement, CodeBuilder builder, String className, String classNameBuilderImpl) {
        for (Element enclosed : classElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.CONSTRUCTOR) {
                processConstructor(builder, className, classNameBuilderImpl, enclosed);
            }
        }
    }

    private void processConstructor(CodeBuilder builder, String className, String classNameBuilderImpl, Element enclosed) {
        generateBaseConstructors(builder, className, ((ExecutableElement) enclosed).getParameters());

        for (VariableElement parameter : ((ExecutableElement) enclosed).getParameters()) {
            builder.append(generateBuilderMethod(parameter, classNameBuilderImpl));
        }

        builder.append(generateStaticJsonInput(builder, className, classNameBuilderImpl, ((ExecutableElement) enclosed).getParameters()));
    }

    private void generateBaseConstructors(CodeBuilder builder, String className, List<? extends VariableElement> parameters) {
        builder.append(generateBasicConstructor(className, parameters));

        boolean constructorCanBeSimplified = false;
        List<ComplexConstructorVariable> variables = new ArrayList<>();
        // Simple constructor if it contains elements of the ISimpleBlock interface
        for (var parameter : parameters) {
            if (parameterCanBeSimplified(parameter)) {
                constructorCanBeSimplified = true;
                variables.add(new ComplexConstructorVariable("String", getSimpleTypeNameWithGenerics(parameter.asType()), parameter.getSimpleName().toString(), true));
            } else {
                variables.add(new ComplexConstructorVariable(getSimpleTypeNameWithGenerics(parameter.asType()), parameter.getSimpleName().toString(), false));
            }
        }

        if (constructorCanBeSimplified) {
            builder.append(generateSimplifiedConstructor(className, variables)).emptyLine();
        }
    }

    private CodeBuilder generateBasicConstructor(String className, List<? extends VariableElement> parameters) {
        CodeBuilder code = new CodeBuilder();

        CodeBuilder constructorParameters = CodeBuilder.quickBuilt(parameters.stream().map(parameter -> getSimpleTypeNameWithGenerics(parameter.asType()) + " " + parameter.getSimpleName().toString()).collect(Collectors.toList()));

        code.append("\tpublic static %s create(%s) {", className, constructorParameters.generateParams())
                .append("\t\treturn start()");

        CodeBuilder builderParameters = CodeBuilder.quickBuilt(
                parameters.stream().map(parameter -> String.format("\t\t\t\t.%s(%s)", parameter.getSimpleName().toString(), parameter.getSimpleName().toString())).collect(Collectors.toList())
        );

        code.append(builderParameters.generate())
                .append("\t\t\t\t.build();")
                .append("\t}")
                .emptyLine();

        return code;
    }

    private boolean parameterCanBeSimplified(VariableElement parameter) {
        String classNameToCheck = parameter.asType().toString();
        TypeElement classTypeElement = processingEnvironment.getElementUtils().getTypeElement(classNameToCheck);
        TypeElement interfaceTypeElement = processingEnvironment.getElementUtils().getTypeElement(SIMPLE_BLOCK_INTERFACE);

        TypeMirror typeMirror = parameter.asType();
        if (typeMirror instanceof DeclaredType) {
            DeclaredType declaredType = (DeclaredType) typeMirror;
            Element element = declaredType.asElement();

            try {
                if (element instanceof TypeElement) {
                    for (TypeMirror implementedInterface : classTypeElement.getInterfaces()) {
                        if (processingEnvironment.getTypeUtils().isSameType(implementedInterface, interfaceTypeElement.asType())) {
                            return true;
                        }
                    }
                }
            } catch (Exception ex) {
                System.err.println(String.format("Simplification process failure: %s", ex));
            }
        }

        return false;
    }

    private CodeBuilder generateSimplifiedConstructor(String className, List<ComplexConstructorVariable> variables) {
        CodeBuilder code = new CodeBuilder();

        CodeBuilder simpleConstructorParameters = CodeBuilder.quickBuilt(
                variables.stream().map(ComplexConstructorVariable::getVariable).collect(Collectors.toList())
        );

        code.append("\tpublic static %s create(%s) {", className, simpleConstructorParameters.generateParams())
                .append("\t\treturn start()");

        CodeBuilder complexConstructorInitializations = CodeBuilder.quickBuilt(
                variables.stream().map(variable -> "\t\t\t\t." + variable.builderComplexAddition()).collect(Collectors.toList())
        );

        code.append(complexConstructorInitializations.generate())
                .append("\t\t\t\t.build();")
                .append("\t}");

        return code;
    }

    private CodeBuilder generateBuilderMethod(VariableElement parameter, String classNameBuilderImpl) {
        CodeBuilder code = new CodeBuilder();
        String typeName = getSimpleTypeNameWithGenerics(parameter.asType());
        typeNames.add(typeName);
        code.append("\tpublic " + classNameBuilderImpl + " " + parameter.getSimpleName() + "(" + typeName + " " + parameter.getSimpleName() + ") {")
                .append("\t\tsetField(\"" + typeName + "\", " + parameter.getSimpleName() + ");")
                .append("\t\treturn this;")
                .append("\t}")
                .emptyLine();

        return code;
    }

    private CodeBuilder generateBuildOverride(String className) {
        CodeBuilder code = new CodeBuilder();

        CodeBuilder validatorParameters = CodeBuilder.quickBuilt(
                typeNames.stream().map(typeName -> "\"" + typeName + "\"").collect(Collectors.toList())
        );

        code.append("\t@Override")
                .append("\tpublic " + className + " build() {")
                .append("\t\tvalidate(" + validatorParameters.generateParams() + ");")
                .append("\t\treturn new " + className + "(");

        CodeBuilder constructorParameters = CodeBuilder.quickBuilt(
                typeNames.stream().map(typeName -> "\t\t\t\t(" + typeName + ") fields.get(\"" + typeName + "\")").collect(Collectors.toList())
        );

        code.append(constructorParameters.generateLineParams());

        code.append("\t\t);")
                .append("\t}");

        return code;
    }

    private CodeBuilder generateStaticJsonInput(CodeBuilder builder, String className, String classNameBuilderImpl, List<? extends VariableElement> parameters) {
        CodeBuilder code = new CodeBuilder();

        CodeBuilder objectParameters = CodeBuilder.quickBuilt(
                parameters.stream().map(this::mapObjectParamsToJson).collect(Collectors.toList())
        );

        code.append("\tpublic static Map<String, Object> jsonInput() {")
                .append("\t\tMap<String, Object> mappings = new LinkedHashMap<>();")
                .emptyLine()
                .append(objectParameters.generate())
                .emptyLine()
                .append("\t\treturn mappings;")
                .append("\t}")
                .emptyLine();

        return code;
    }

    private String mapObjectParamsToJson(VariableElement parameter) {
        String classNameToCheck = parameter.asType().toString();
        TypeElement classTypeElement = processingEnvironment.getElementUtils().getTypeElement(classNameToCheck);

        try {
            if (classTypeElement.getSuperclass().toString().equals(ABSTRACT_BLOCK_SUPERCLASS)) {
                String className = getSimpleTypeNameWithGenerics(parameter.asType());
                addClassImports(String.format("%s%s", className, BUILDER_IMPL_NAME), String.format("%s.%s%s", BUILDER_PACKAGE_NAME, className, BUILDER_IMPL_NAME), Type.BUILDER);
                return "\t\tmappings.put(\"" + getSimpleTypeNameWithGenerics(parameter.asType()) + "\", " + getSimpleTypeNameWithGenerics(parameter.asType()) + "Builder.jsonInput());";
            } else {
                return "\t\tmappings.put(\"" + getSimpleTypeNameWithGenerics(parameter.asType()) + "\", \"" + parameter.getSimpleName() + "\");";
            }
        } catch (Exception ex) {
            return "\t\tmappings.put(\"" + getSimpleTypeNameWithGenerics(parameter.asType()) + "\", \"" + parameter.getSimpleName() + "\");";
        }
    }
}
