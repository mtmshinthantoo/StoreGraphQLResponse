package org.example.config;

import org.example.extract.ValueExtractor;

import java.util.ArrayList;
import java.util.List;

public final class RowExplosion {
    private final String path;
    private final List<ColumnMapping> columns;
    private final EmptyExplosionBehavior emptyBehavior;

    private RowExplosion(Builder builder) {
        this.path = builder.path;
        this.columns = List.copyOf(builder.columns);
        this.emptyBehavior = builder.emptyBehavior;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String path() {
        return path;
    }

    public List<ColumnMapping> columns() {
        return columns;
    }

    public EmptyExplosionBehavior emptyBehavior() {
        return emptyBehavior;
    }

    public static final class Builder {
        private String path;
        private final List<ColumnMapping> columns = new ArrayList<>();
        private EmptyExplosionBehavior emptyBehavior = EmptyExplosionBehavior.INCLUDE_BLANK_ROW;

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder addColumn(String columnName, ValueExtractor extractor) {
            this.columns.add(new ColumnMapping(columnName, extractor));
            return this;
        }

        public Builder skipWhenEmpty() {
            this.emptyBehavior = EmptyExplosionBehavior.SKIP_ROW;
            return this;
        }

        public Builder includeBlankRowWhenEmpty() {
            this.emptyBehavior = EmptyExplosionBehavior.INCLUDE_BLANK_ROW;
            return this;
        }

        public RowExplosion build() {
            if (path == null || path.isBlank()) {
                throw new IllegalStateException("Explosion path is required.");
            }
            if (columns.isEmpty()) {
                throw new IllegalStateException("Explosion must contain at least one column.");
            }
            return new RowExplosion(this);
        }
    }
}
