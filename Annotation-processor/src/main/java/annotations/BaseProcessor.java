package annotations;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseProcessor {
    protected String className;
    protected String genClassLocation;
    protected String genClassName;
    protected Element element;
    protected ProcessingEnvironment processingEnvironment;
    protected CodeBuilder builder;
    protected Set<Pair> classImports;

    public BaseProcessor(String className, String genClassLocation,  String genClassName, ProcessingEnvironment processingEnvironment, Element element) {
        this.className = className;
        this.genClassLocation = genClassLocation;
        this.genClassName = genClassName;
        this.classImports = new HashSet<>();
        this.processingEnvironment = processingEnvironment;
        this.element = element;
        this.builder = new CodeBuilder();
    }

    /**
     * Override below value and use it in all derived base processor, the system will then call the process here
     *
     * @return success or failure depending on code generation
     */
    protected abstract boolean process();

    protected void addClassImports(String className, String classImport, Type type) {
        Pair classPair = new Pair(className, classImport, type);
        classImports.add(classPair);
    }

    protected String getSimpleTypeNameWithGenerics(TypeMirror typeMirror) {
        String fullTypeName = typeMirror.toString();
        return removePackageNames(fullTypeName);
    }

    protected void createClass() {
        CodeBuilder initBuild = new CodeBuilder()
                .append(generateDefaultComments())
                .emptyLine()
                .append(generatePackageName())
                .emptyLine()
                .append(generateRequiredImports())
                .emptyLine();

        builder.add(0, initBuild);

        createFile();
    }

    private CodeBuilder generateDefaultComments() {
        return new CodeBuilder()
                .append("/*")
                .append(" * -----------------------------------------------------------------")
                .append(" * This file has been auto-generated by processor annotations.")
                .append(" * Do not modify this file directly as changes will be overwritten.")
                .append(String.format(" * Generated on: [%s - UTC]", Instant.now()))
                .append(" * -----------------------------------------------------------------")
                .append(" */");
    }

    private CodeBuilder generatePackageName() {
        return new CodeBuilder().append(String.format("package %s;", genClassLocation));
    }

    private CodeBuilder generateRequiredImports() {
        return CodeBuilder.quickBuilt(classImports.stream().map(value -> String.format("import %s;", value.getRight())).collect(Collectors.toList()));
    }

    private void createFile() {
        try {
            JavaFileObject builderFile = processingEnvironment.getFiler().createSourceFile(this.genClassName);

            try (BufferedWriter writer = new BufferedWriter(builderFile.openWriter())) {
                writer.write(this.builder.generate());
            }
        } catch (Exception ex) {
            System.err.println(String.format("Failure on file creation", ex));
        }
    }

    private String removePackageNames(String fullTypeName) {
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

        if (!fullTypeName.contains("<")) {
            addClassImports(result.toString(), fullTypeName, Type.GENERAL);
        }

        return result.toString();
    }

    private String extractSimpleName(String typeName) {
        int lastDotIndex = typeName.lastIndexOf('.');
        return (lastDotIndex == -1) ? typeName : typeName.substring(lastDotIndex + 1);
    }

    public Set<Pair> getClassImports() {
        return classImports;
    }

    public void addClassImports(Set<Pair> classImports) {
        this.classImports.addAll(classImports);
    }

    public String getClassName() {
        return className;
    }

    public String getGenClassName() {
        return genClassName;
    }

    public String getGenClassLocation() {
        return genClassLocation;
    }
}
