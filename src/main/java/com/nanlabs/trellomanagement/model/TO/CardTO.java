package com.nanlabs.trellomanagement.model.TO;

import java.util.Map;

public abstract class CardTO {
    public String type;
    abstract boolean validArguments(Map arguments);
}
