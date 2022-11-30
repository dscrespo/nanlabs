package com.nanlabs.trellomanagement.model.TO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

public class IssueTO extends CardTO {

    @JsonProperty("name")
    private String title;
    @JsonProperty("desc")
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private IssueTO(){};

    public IssueTO(LinkedHashMap param){
        if(validArguments(param)){
        this.type = param.get("type").toString();
        this.title = param.get("title").toString();
        this.description = param.get("description").toString();
        } else {
            throw new IllegalArgumentException("no se puede crear un Issue");
        }
    }

    @Override
    boolean validArguments(Map arguments) {
        if(arguments.get("type") != null &&  arguments.get("title") != null && arguments.get("description") != null){
            return true;
        } else {
            return false;
        }
    }
}
