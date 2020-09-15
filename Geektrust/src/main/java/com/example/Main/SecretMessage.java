package com.example.Main;
import com.example.Interface.secret;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
public class SecretMessage implements secret {
    private int ALPHABET_SIZE = 26;
    private int ASCII_VALUE = 65;
    private List<Character> secretMSG;
    private HashMap<Character, Integer> decodeMSG;
    private StringBuffer buffer;
    public SecretMessage()
    {
        this.buffer = new StringBuffer();
        this.decodeMSG = new HashMap<>();
    }
    @Override
    public boolean SecretMessage(List<String> message, String emblem) {
        secretMSG = this.append(message);
        emblem = emblem.toUpperCase();
        return DecodedMessage(secretMSG,emblem,emblem.length());
    }
    @Override
    public List<Character> append(List<String> message) {
        buffer.delete(0, buffer.length());
        message.stream().skip(1).forEach(s -> {
            buffer.append(s);
        });
        return buffer.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
    @Override
    public boolean DecodedMessage(List<Character> secretMSG, String emblem,int cipherKey) {
        secretMSG.stream().forEach(charMSG -> {
            int value = subtract(charMSG,cipherKey);
            char character = (char) ( value < ASCII_VALUE ? (value + ALPHABET_SIZE) : value );
            decodeMSG.put(character, decodeMSG.getOrDefault(character, 0) + 1);
        });
        return isValidSecretMessage(decodeMSG,emblem);
    }
    @Override
    public boolean isValidSecretMessage(HashMap<Character,Integer> decodeMSG,String emblem) {
        AtomicInteger flag= new AtomicInteger(0);
        emblem.chars()
                .forEach(i -> {
                    if(decodeMSG.get((char)i)!=null && decodeMSG.get((char)i)>0)
                        decodeMSG.put((char) i, decodeMSG.getOrDefault((char) i, 0) - 1);
                    else
                    flag.set(1);
                });
        return (flag.get() == 1) ? false : true ;
    }
    @Override
    public int subtract(char a, int b) {
        return Math.subtractExact(a,b);
    }
    @Override
    public void display(ArrayList<String> ruler) {
        if(ruler.size()<4)
            System.out.println("None");
        else
        {
            Iterator<String> it = ruler.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+ " ");
            }
        }
    }
}
