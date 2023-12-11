package com.olvins.kit.dotnetdevkit.utils;

public class Formatters {
    public static class EndOfLineBraceFormat implements IFormatter {

        @Override
        public String format(String code) {
            return null; // Not implemented yet
        }
    }

    public static class StandaloneBraceFormat implements IFormatter {

        @Override
        public String format(String code) {
            return formatBracersCode(code);
        }
    }

    private static String formatBracersCode(String code) {
        int indentLevel = 0;
        StringBuilder formattedCode = new StringBuilder();

        String[] lines = code.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            if (line.contains("}")) {
                indentLevel--;
            }

            String indentedLine = "\t".repeat(Math.max(0, indentLevel)) + line;
            formattedCode.append(indentedLine);

            if (i < lines.length - 1) {
                formattedCode.append("\n");
            }

            if (line.contains("{")) {
                indentLevel++;
            }
        }

        return formattedCode.toString();
    }
}
