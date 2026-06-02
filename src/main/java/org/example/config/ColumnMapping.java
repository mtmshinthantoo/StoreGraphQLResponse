package org.example.config;

import org.example.extract.ValueExtractor;

public record ColumnMapping(String columnName, ValueExtractor extractor) {
    public ColumnMapping {
        if (columnName == null || columnName.isBlank()) {
            throw new IllegalArgumentException("Column name is required.");
        }
        if (extractor == null) {
            throw new IllegalArgumentException("Extractor is required.");
        }
    }
}
