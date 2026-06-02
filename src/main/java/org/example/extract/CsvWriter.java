package org.example.extract;

import java.util.List;

final class CsvWriter {
    private CsvWriter() {
    }

    static String write(List<String> headers, List<List<String>> records) {
        StringBuilder csv = new StringBuilder();
        appendRecord(csv, headers);
        for (List<String> record : records) {
            appendRecord(csv, record);
        }
        return csv.toString();
    }

    private static void appendRecord(StringBuilder csv, List<String> values) {
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                csv.append(',');
            }
            appendValue(csv, values.get(i));
        }
        csv.append(System.lineSeparator());
    }

    private static void appendValue(StringBuilder csv, String value) {
        String safeValue = value == null ? "" : value;
        boolean needsQuotes = safeValue.indexOf(',') >= 0
                || safeValue.indexOf('"') >= 0
                || safeValue.indexOf('\n') >= 0
                || safeValue.indexOf('\r') >= 0;

        if (!needsQuotes) {
            csv.append(safeValue);
            return;
        }

        csv.append('"');
        for (int i = 0; i < safeValue.length(); i++) {
            char character = safeValue.charAt(i);
            if (character == '"') {
                csv.append("\"\"");
            } else {
                csv.append(character);
            }
        }
        csv.append('"');
    }
}
