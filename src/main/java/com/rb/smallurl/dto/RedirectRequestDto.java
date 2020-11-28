package com.rb.smallurl.dto;


import javax.validation.constraints.NotNull;

public class RedirectRequestDto {

    @NotNull
    private String alias;

    @NotNull
    private String url;

    public RedirectRequestDto(@NotNull String alias, @NotNull String url) {
        this.alias = alias;
        this.url = url;
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
}
