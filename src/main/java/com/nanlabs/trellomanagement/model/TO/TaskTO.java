package com.nanlabs.trellomanagement.model.TO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskTO extends CardTO{
    @JsonProperty("name")
    private String title;
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public TaskTO(){}

    public TaskTO(LinkedHashMap param){
        if(validArguments(param)){
            this.type = param.get("type").toString();
            this.title = param.get("title").toString();
            this.category = param.get("category").toString();
        } else {
            throw new IllegalArgumentException("no se puede crear un Task ");
        }
    }

    @Override
    boolean validArguments(Map arguments) {
        if(arguments.get("type") != null &&  arguments.get("title") != null &&  arguments.get("category") != null){
            return true;
        } else {
            return false;
        }
    }

}
