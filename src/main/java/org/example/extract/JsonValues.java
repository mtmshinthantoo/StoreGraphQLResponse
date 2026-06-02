package org.example.extract;

final class JsonValues {
    private JsonValues() {
    }

    static String toCellValue(JsonValue node) {
        if (node == null || node.isNull()) {
            return "";
        }
        if (node.isString() || node.isNumber() || node.isBoolean()) {
            return node.asScalarText();
        }
        return node.toCompactJson();
    }
}
