package com.example.Main;
import com.example.Interface.reader;
import java.io.*;
import java.util.*;
public class FastReader implements reader
{
    private BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;
    public FastReader(File file)
    {
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String next()
    {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements())
        {
            try
            {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }
    @Override
    public int nextInt()
    {
        return Integer.parseInt(next());
    }
    @Override
    public long nextLong()
    {
        return Long.parseLong(next());
    }
    @Override
    public double nextDouble()
    {
        return Double.parseDouble(next());
    }
    @Override
    public String nextLine()
    {
        String temp = "";
        try
        {
            temp = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return temp;
    }
}
