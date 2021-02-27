package com.example;

public class Player {
    private int id;
    private String namn;
    private int age;
    private int jersey;

  
    public void SetId(int v)
    {
        id = v;
    }

    public int GetId()
    {
        return id;
    }

    public void SetNamn(String v)
    {
        namn = v;
    }

    public void SetAge(int v)
    {
        age  = v;
    }

    public void SetJersey(int v)
    {
        jersey  = v;
    }

    public String GetNamn()
    {
        return namn;
    }

    public int GetAge()
    {
        return age;
    }

    public int GetJersey()
    {
        return jersey;
    }
    
}
