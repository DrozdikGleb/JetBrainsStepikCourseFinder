package com.example.gleb.stepikcoursefinder.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//сгенерировано с помощью http://www.jsonschema2pojo.org/
public class Meta {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;
    @SerializedName("has_previous")
    @Expose
    private Boolean hasPrevious;

    public Meta() {

    }

    public Meta(Integer page, Boolean hasNext, Boolean hasPrevious) {
        this.page = page;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

}
