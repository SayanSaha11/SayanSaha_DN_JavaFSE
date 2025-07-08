package com.cognizant.spring_learn;

public class Country {

    private String code;
    private String name;

    public Country() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString(){
        return "The name of the country is "+name+" & its code is "+code+".";
    }

}
