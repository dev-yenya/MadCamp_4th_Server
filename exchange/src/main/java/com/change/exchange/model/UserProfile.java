package com.change.exchange.model;


public class UserProfile{
    private String id;
    //private String password;
    private String name;
    private String email;

    public UserProfile(String id, String name, String email){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String toString(){
        return "{id : "+id+", name : "+name+", email : "+email+"}";
    }

}