package com.jsystems.qa.qaapi.model.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty(value = "ID", required = true)
    public long id;

    @JsonProperty(value = "Title", required = true)
    public String  title;

    @JsonProperty(value = "Description", required = true)
    public String description;

    @JsonProperty(value = "PageCount", required = true)
    public int pageCount;

    @JsonProperty(value = "Excerpt", required = true)
    public String excerpt;

    @JsonProperty(value = "PublishDate", required = true)
    public String publishDate;

    public Book(long id, String title, String description, int pageCount, String excerpt, String publishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public Book() {
    }
}
