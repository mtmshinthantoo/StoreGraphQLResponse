package org.example.definition;

import org.example.config.CsvExportConfig;

public interface ShopifyCsvExportDefinition {
    String exportName();

    String apiResponse();

    CsvExportConfig config();
}
