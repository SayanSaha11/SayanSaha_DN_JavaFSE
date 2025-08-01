package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Country() {

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String toString(){
        return "Country [code=" + code + ", name=" + name + "]";
    }
}


