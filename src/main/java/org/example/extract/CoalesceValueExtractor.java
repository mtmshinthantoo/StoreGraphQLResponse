package org.example.extract;

import java.util.Arrays;
import java.util.List;

final class CoalesceValueExtractor implements ValueExtractor {
    private final List<String> paths;

    CoalesceValueExtractor(String... paths) {
        if (paths == null || paths.length == 0) {
            throw new IllegalArgumentException("At least one path is required.");
        }
        this.paths = Arrays.stream(paths)
                .filter(path -> path != null && !path.isBlank())
                .toList();
        if (this.paths.isEmpty()) {
            throw new IllegalArgumentException("At least one non-blank path is required.");
        }
    }

    @Override
    public String extract(JsonValue context) {
        for (String path : paths) {
            String value = JsonValues.toCellValue(JsonPath.findOne(context, path));
            if (!value.isBlank()) {
                return value;
            }
        }
        return "";
    }
}
