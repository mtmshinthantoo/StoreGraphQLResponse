package org.example.extract;

final class PathValueExtractor implements ValueExtractor {
    private final String path;

    PathValueExtractor(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Value path is required.");
        }
        this.path = path;
    }

    @Override
    public String extract(JsonValue context) {
        JsonValue value = JsonPath.findOne(context, path);
        return JsonValues.toCellValue(value);
    }
}
