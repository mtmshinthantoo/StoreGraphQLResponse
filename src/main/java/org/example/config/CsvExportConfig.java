package org.example.config;

import org.example.extract.ValueExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class CsvExportConfig {
    private final String rootRowsPath;
    private final List<ColumnMapping> columns;
    private final List<RowExplosion> rowExplosions;

    private CsvExportConfig(Builder builder) {
        this.rootRowsPath = builder.rootRowsPath;
        this.columns = List.copyOf(builder.columns);
        this.rowExplosions = List.copyOf(builder.rowExplosions);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String rootRowsPath() {
        return rootRowsPath;
    }

    public List<ColumnMapping> columns() {
        return columns;
    }

    public List<RowExplosion> rowExplosions() {
        return rowExplosions;
    }

    public static final class Builder {
        private String rootRowsPath;
        private final List<ColumnMapping> columns = new ArrayList<>();
        private final List<RowExplosion> rowExplosions = new ArrayList<>();

        public Builder rootRows(String path) {
            this.rootRowsPath = path;
            return this;
        }

        public Builder addColumn(String columnName, ValueExtractor extractor) {
            this.columns.add(new ColumnMapping(columnName, extractor));
            return this;
        }

        public Builder explodeRows(String path, Consumer<RowExplosion.Builder> configure) {
            RowExplosion.Builder builder = RowExplosion.builder().path(path);
            configure.accept(builder);
            this.rowExplosions.add(builder.build());
            return this;
        }

        public CsvExportConfig build() {
            if (rootRowsPath == null || rootRowsPath.isBlank()) {
                throw new IllegalStateException("Root rows path is required.");
            }
            if (columns.isEmpty() && rowExplosions.isEmpty()) {
                throw new IllegalStateException("At least one column or row explosion is required.");
            }
            return new CsvExportConfig(this);
        }
    }
}
