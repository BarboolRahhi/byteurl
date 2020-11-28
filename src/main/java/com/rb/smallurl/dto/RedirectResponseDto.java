package com.rb.smallurl.dto;

import java.time.LocalDate;

public class RedirectResponseDto {

    private String alias;

    private String url;

    private LocalDate createdAt;


    public RedirectResponseDto(String alias, String url, LocalDate createdAt) {
        this.alias = alias;
        this.url = url;
        this.createdAt = createdAt;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
