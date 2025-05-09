package com.person.model;

import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;

//class preson to define a person and it's attributes
//using JPA annotations

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    //constructor
    public Person(Long id, String name, int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }

    //default constructor
    public Person() {}

    //getters and setters methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }
    

}
