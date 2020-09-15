package com.example.Main;
import java.io.*;
import java.util.*;
public class PropertyFile {
    private InputStream inputStream;
    private Properties property;
    private HashMap<String,String> Emblem;
    public PropertyFile(String propFileName) throws IOException {
        this.property = new Properties();
        this.inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        this.Emblem = new HashMap<>();
        loadProperty();
    }
    public void loadProperty() throws IOException {
        if (inputStream != null) {
            property.load(inputStream);
        } else {
            throw new FileNotFoundException("Property file not found ");
        }
    }
    public HashMap<String,String> accessPropertyFile()
    {
        List<String> kingdoms = Arrays.asList(property.getProperty("Kingdoms").split(","));
        kingdoms.stream().forEach(kingdom ->{
            Emblem.put(kingdom,property.getProperty(kingdom));
        });
        return  Emblem;
    }
    public String readRuler()
    {
        String ruler = property.getProperty("RULER");
        return  ruler;
    }
}
