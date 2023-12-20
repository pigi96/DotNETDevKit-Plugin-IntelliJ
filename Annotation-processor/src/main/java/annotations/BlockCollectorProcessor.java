package annotations;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import java.util.stream.Collectors;

public class BlockCollectorProcessor extends BaseProcessor {
    private static final String CLASS_NAME = "BuilderCollections";
    private static final String GEN_CLASS_NAME = "BuilderCollections";
    private static final String GEN_CLASS_LOCATION = "com.olvins.kit";

    public BlockCollectorProcessor(ProcessingEnvironment processingEnvironment, Element element) {
        super(CLASS_NAME, GEN_CLASS_LOCATION, GEN_CLASS_NAME, processingEnvironment, element);
    }

    public boolean process() {
        addClassImports("List", "java.util.List", Type.GENERAL);
        addClassImports("Map", "java.util.Map", Type.GENERAL);
        addClassImports("LinkedHashMap", "java.util.LinkedHashMap", Type.GENERAL);
        addClassImports("Collectors", "java.util.stream.Collectors", Type.GENERAL);

        builder.append("public class %s {", className)
                .append("\tprivate Map<String, Object> blocks = new LinkedHashMap<>();")
                .emptyLine()
                .append(generatePrivateConstructor())
                .emptyLine()
                .append(generateAllGetterMap())
                .emptyLine()
                .append(generateGetterMap())
                .emptyLine()
                .append(generateListOfPossibleBlocks())
                .append("}")
                .emptyLine();

        return true;
    }

    private CodeBuilder generatePrivateConstructor() {
        CodeBuilder builders = CodeBuilder.quickBuilt(
                classImports.stream()
                        .filter(value -> value.getType() == Type.BUILDER)
                        .map(value -> String.format("\t\tblocks.put(\"%s\", %s.jsonInput());", value.getLeft(), value.getLeft()))
                        .collect(Collectors.toList())
        );

        return new CodeBuilder()
                .append("\t/** Disabled access to class, can only be used through static methods")
                .append("\t * ------------------------------------------------------------------")
                .append("\t * All builders that were generated with @BlockBuilder annotation will")
                .append("\t * be initialized here and used as a proxy for frontend elements")
                .append("\t */")
                .append("\tprivate %s() {", className)
                .append(builders)
                .append("\t}")
                .emptyLine();
    }

    private CodeBuilder generateAllGetterMap() {
        return new CodeBuilder()
                .append("\t/** Retrieve all possible blocks */")
                .append("\tpublic Map<String, Object> getBlocks() {")
                .append("\t\treturn blocks;")
                .append("\t}");
    }

    private CodeBuilder generateGetterMap() {
        return new CodeBuilder()
                .append("\t/** Retrieve specific block */")
                .append("\tpublic Object getBlock(String blockName) {")
                .append("\t\treturn blocks.get(blockName);")
                .append("\t}");
    }

    private CodeBuilder generateListOfPossibleBlocks() {
        return new CodeBuilder()
                .append("\t/** Retrieve list of all possible blocks by their name */")
                .append("\tpublic List<String> getBlockChoices() {")
                .append("\t\treturn blocks.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());")
                .append("\t}");
    }
}
