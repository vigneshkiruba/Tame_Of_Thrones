package com.example.Interface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public interface secret {
    boolean SecretMessage(List<String> message, String emblem);
    List<Character> append(List<String> message);
    boolean DecodedMessage(List<Character> secretMSG, String emblem,int cipherKey);
    boolean isValidSecretMessage(HashMap<Character,Integer> decodeMSG,String emblem);
    int subtract(char a,int b);
    void display(ArrayList<String> ruler);
}
