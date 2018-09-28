package com.example.charles.lab2;

public class CData {

    public String name;
    public String nick_name;
    public String country;


    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CData(String name, String nick_name,String country){
        this.name = name;
        this.nick_name = nick_name;
        this.country = country;
    }
}
