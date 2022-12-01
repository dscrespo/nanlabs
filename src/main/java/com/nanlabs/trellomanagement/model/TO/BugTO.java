package com.nanlabs.trellomanagement.model.TO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanlabs.trellomanagement.utils.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class BugTO extends CardTO {

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

    private BugTO(){};

    public void setDescription(String description) {
        this.description = description;
    }

    public BugTO(LinkedHashMap param){
        if(validArguments(param)){
        this.type = param.get("type").toString();
        this.description = param.get("description").toString();
        this.title = "bug" + "-" + Utils.generateRandomWord() + "-" + Utils.generateRandomNumber();
        } else {
            throw new IllegalArgumentException("no se puede crear un Bug ");
        }
    }

    @Override
    boolean validArguments(Map arguments) {
        if(arguments.get("type") != null &&  arguments.get("description") != null){
            return true;
        } else {
            return false;
        }
    }
}
