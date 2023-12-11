package annotations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeBuilder {
    private List<String> codeLines = new LinkedList<>();

    public static CodeBuilder quickBuilt(List<String> values) {
        CodeBuilder builder = new CodeBuilder();
        for (String value : values) {
            builder.append(value);
        }
        return builder;
    }

    public CodeBuilder append(String codeLine) {
        codeLines.add(codeLine);
        return this;
    }

    public CodeBuilder emptyLine() {
        codeLines.add("");
        return this;
    }

    public void add(int location, List<String> values) {
        codeLines.addAll(location, values);
    }

    public String generate() {
        return codeLines.stream().collect(Collectors.joining("\n"));
    }

    public String generateParams() {
        return codeLines.stream().collect(Collectors.joining(", "));
    }

    public String generateLineParams() {
        return codeLines.stream().collect(Collectors.joining(",\n"));
    }

    public List<String> getCodeLines() {
        return codeLines;
    }
}
