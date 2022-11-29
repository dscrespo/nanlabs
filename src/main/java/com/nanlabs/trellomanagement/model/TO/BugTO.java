package com.nanlabs.trellomanagement.model.TO;

import java.util.LinkedHashMap;
import java.util.Map;

public class BugTO extends CardTO {

    private String description;

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
