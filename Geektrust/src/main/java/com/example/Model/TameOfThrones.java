package com.example.Model;
import java.util.*;
public class TameOfThrones {
    private HashMap<String,String> Emblem;
    public TameOfThrones(HashMap<String,String> emblem)
    {
        this.Emblem = emblem;
    }
    public String kingdomName(String kingdoms) {
        String emblem = Emblem.get(kingdoms);
        return emblem;
    }
}
