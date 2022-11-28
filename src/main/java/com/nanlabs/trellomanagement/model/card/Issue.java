package com.nanlabs.trellomanagement.model.card;

import java.util.LinkedHashMap;
import java.util.Map;

public class Issue extends Card{

    private String title;
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
    private Issue(){};

    public Issue(LinkedHashMap param){
        if(validArguments(param)){
        this.type = param.get("type").toString();
        this.title = param.get("title").toString();
        this.description = param.get("description").toString();
        } else {
            throw new IllegalArgumentException("no se puede crear un Issue ");
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
