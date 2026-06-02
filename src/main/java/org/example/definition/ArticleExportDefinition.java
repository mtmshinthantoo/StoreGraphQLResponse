package org.example.definition;

import org.example.config.CsvExportConfig;

import static org.example.extract.Extractors.join;
import static org.example.extract.Extractors.singleLine;
import static org.example.extract.Extractors.value;

public final class ArticleExportDefinition implements ShopifyCsvExportDefinition {
    @Override
    public String exportName() {
        return "Articles";
    }

    @Override
    public String apiResponse() {
        return """
            {
                "data": {
                    "articles": {
                        "edges": [
                            {
                                "node": {
                                    "id": "gid://shopify/Article/560974561460",
                                    "blog": {
                                        "id": "gid://shopify/Blog/74552574132"
                                    },
                                    "author": {
                                        "name": "article1"
                                    },
                                    "body": "<h1>I like articles</h1>\\n<p><strong>Yea</strong>, I like posting them through <span class=\\"caps\\">REST</span>.</p>",
                                    "createdAt": "2024-07-26T06:23:57Z",
                                    "handle": "my-new-article-title-1",
                                    "image": null,
                                    "publishedAt": "2011-03-24T15:45:47Z",
                                    "summary": null,
                                    "tags": [
                                        "Has Been Tagged",
                                        "This Post"
                                    ],
                                    "templateSuffix": null,
                                    "title": "My new Article title",
                                    "updatedAt": "2024-07-26T06:23:57Z",
                                    "isPublished": true,
                                    "customAttributes": [
                                        {
                                            "key": "engraving",
                                            "value": "Happy Birthday, chit ka lay"
                                        },
                                        {
                                            "key": "gift_wrap",
                                            "value": "yes"
                                        }
                                    ]
                                }
                            },
                            {
                                "node": {
                                    "id": "gid://shopify/Article/560974234245",
                                    "blog": {
                                        "id": "gid://shopify/Blog/745525745353"
                                    },
                                    "author": {
                                        "name": "article2"
                                    },
                                    "body": "<h1>I like articles</h1>\\n<p><strong>Yea</strong>, I like posting them through <span class=\\"caps\\">REST</span>.</p>",
                                    "createdAt": "2024-07-26T06:23:57Z",
                                    "handle": "my-new-article-title-2",
                                    "image": null,
                                    "publishedAt": "2021-03-24T15:45:47Z",
                                    "summary": null,
                                    "tags": [
                                        "Has Been Tagged",
                                        "This Post",
                                        "New Tag",
                                        "Shin Thant Oo"
                                    ],
                                    "templateSuffix": null,
                                    "title": "My new Article title",
                                    "updatedAt": "2024-07-26T06:23:57Z",
                                    "isPublished": true,
                                    "customAttributes": [
                                        {
                                            "key": "celebration",
                                            "value": "Happy 2nd Anniversary, chit ka lay"
                                        },
                                        {
                                            "key": "gift",
                                            "value": "Happy Birthday"
                                        },
                                        {
                                            "key": "gift_wrap",
                                            "value": "yes"
                                        }
                                    ]
                                }
                            }
                        ],
                        "pageInfo": {
                            "hasNextPage": false,
                            "hasPreviousPage": false,
                            "startCursor": "eyJsYXN0X2lkIjo1NjA5NzQ1NjE0NjAsImxhc3RfdmFsdWUiOiI1NjA5NzQ1NjE0NjAifQ==",
                            "endCursor": "eyJsYXN0X2lkIjo1NjA5NzQ1NjE0NjAsImxhc3RfdmFsdWUiOiI1NjA5NzQ1NjE0NjAifQ=="
                        }
                    }
                },
                "extensions": {
                    "cost": {
                        "requestedQueryCost": 46,
                        "actualQueryCost": 3,
                        "throttleStatus": {
                            "maximumAvailable": 2000.0,
                            "currentlyAvailable": 1997,
                            "restoreRate": 100.0
                        }
                    }
                }
            }
            """;
    }

    @Override
    public CsvExportConfig config() {
        return CsvExportConfig.builder()
                .rootRows("data.articles.edges")
                .addColumn("Article ID", value("node.id"))
                .addColumn("Blog ID", value("node.blog.id"))
                .addColumn("Author Name", value("node.author.name"))
                .addColumn("Body", singleLine("node.body"))
                .addColumn("Created At", value("node.createdAt"))
                .addColumn("Handle", value("node.handle"))
                .addColumn("Image", value("node.image"))
                .addColumn("Published At", value("node.publishedAt"))
                .addColumn("Summary", value("node.summary"))
                .addColumn("Tags", join("node.tags", ","))
                .addColumn("Template Suffix", value("node.templateSuffix"))
                .addColumn("Title", value("node.title"))
                .addColumn("Updated At", value("node.updatedAt"))
                .addColumn("Is Published", value("node.isPublished"))
                .explodeRows("node.customAttributes", customAttribute -> customAttribute
                        .addColumn("Custom Attribute Key", value("key"))
                        .addColumn("Custom Attribute Value", value("value")))
                .build();
    }
}
