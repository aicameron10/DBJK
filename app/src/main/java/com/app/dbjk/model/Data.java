package com.app.dbjk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {

    @SerializedName("metaInformation")
    private Object metaInformation;
    @SerializedName("filters")
    private Object filters;
    @SerializedName("breadcrumbs")
    private Object breadcrumbs;
    @SerializedName("sortOptions")
    private Object sortOptions;
    @SerializedName("pagination")
    private Object pagination;
    @SerializedName("searchText")
    private SearchText searchText;
    @SerializedName("products")
    private List<DetailProducts> products;
    @SerializedName("textMapping")
    private Object textMapping;
    @SerializedName("promotions")
    private Object promotions;
    @SerializedName("redirectUrl")
    private String redirectUrl;
    @SerializedName("displayProperties")
    private Object displayProperties;
    @SerializedName("serializeToVersion")
    private String serializeToVersion;
    @SerializedName("categoryFilter")
    private Object categoryFilter;


    public Object getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(Object metaInformation) {
        this.metaInformation = metaInformation;
    }

    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }

    public Object getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(Object breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public Object getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(Object sortOptions) {
        this.sortOptions = sortOptions;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public SearchText getSearchText() {
        return searchText;
    }

    public void setSearchText(SearchText searchText) {
        this.searchText = searchText;
    }

    public List<DetailProducts> getProducts() {
        return products;
    }

    public void setProducts(List<DetailProducts> products) {
        this.products = products;
    }

    public Object getTextMapping() {
        return textMapping;
    }

    public void setTextMapping(Object textMapping) {
        this.textMapping = textMapping;
    }

    public Object getPromotions() {
        return promotions;
    }

    public void setPromotions(Object promotions) {
        this.promotions = promotions;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Object getDisplayProperties() {
        return displayProperties;
    }

    public void setDisplayProperties(Object displayProperties) {
        this.displayProperties = displayProperties;
    }

    public String getSerializeToVersion() {
        return serializeToVersion;
    }

    public void setSerializeToVersion(String serializeToVersion) {
        this.serializeToVersion = serializeToVersion;
    }

    public Object getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(Object categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

}

