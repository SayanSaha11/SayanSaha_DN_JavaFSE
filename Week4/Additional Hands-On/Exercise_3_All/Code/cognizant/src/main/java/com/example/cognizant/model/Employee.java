package com.example.cognizant.model;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String email;
    private List<String> skills;

    public Employee(int id,String name,String department,String email,List<String> skills){
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.skills = skills;
    }

    public Employee() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

}
