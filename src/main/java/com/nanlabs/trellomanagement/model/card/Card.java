package com.nanlabs.trellomanagement.model.card;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Card {
    public String type;
    abstract boolean validArguments(Map arguments);
}
