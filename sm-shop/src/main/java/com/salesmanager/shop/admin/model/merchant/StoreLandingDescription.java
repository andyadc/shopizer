package com.salesmanager.shop.admin.model.merchant;

import com.salesmanager.core.model.reference.language.Language;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class StoreLandingDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String title;
    private String description;
    private String keywords;
    private String homePageContent;

    private Language language;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomePageContent() {
        return homePageContent;
    }

    public void setHomePageContent(String homePageContent) {
        this.homePageContent = homePageContent;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
