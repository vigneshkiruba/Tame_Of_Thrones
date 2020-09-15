package com.example.Main;
import com.example.Model.TameOfThrones;
import java.io.*;
import java.util.*;
public class mainClass {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        PropertyFile readProperty = new PropertyFile("config.properties");           //Creating Object to Read PropertyFile
        SecretMessage messageObj = new SecretMessage();                                         //Creating Object to perform operations with SecretMessage
        TameOfThrones modelObj = new TameOfThrones(readProperty.accessPropertyFile());          //Parse the value that was read from PropertyFile to create Model
        FastReader input = new FastReader(new File(filePath));                                  //Creating Object for reading inputs in faster manner
        ArrayList<String> ruler= new ArrayList<>();
        ruler.add(readProperty.readRuler());
        String eachLine;
        while ((eachLine = input.nextLine()) !=null) {
            List<String> thrones = Arrays.asList(eachLine.split(" "));
            if(messageObj.SecretMessage(thrones,modelObj.kingdomName(thrones.get(0))) && !ruler.contains(thrones.get(0)))
            {
                    ruler.add(thrones.get(0));
            }
        }
        messageObj.display(ruler);
    }
}
