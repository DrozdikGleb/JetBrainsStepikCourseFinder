package com.example.gleb.stepikcoursefinder.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//сгенерировано с помощью http://www.jsonschema2pojo.org/
public class CoursesResponse {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("search-results")
    @Expose
    private List<SearchResult> searchResults = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    public CoursesResponse(){

    }

    public CoursesResponse(Meta meta, List<SearchResult> searchResults) {
        this.meta = meta;
        this.searchResults = searchResults;
    }
}
