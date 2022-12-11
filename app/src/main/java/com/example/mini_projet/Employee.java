package com.example.mini_projet;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Employee implements Serializable
{


    @Exclude
    private String key;
    private String name;
    private String email;
    private String position;
    private String imageurl;
    public Employee(){}
    public Employee(String name, String email, String position,String imageurl)
    {
        this.name = name;
        this.email=email;
        this.position = position;
        this.imageurl=imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
