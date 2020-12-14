package com.max.ekz.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 1, max = 30, message = "слишком длинное или короткое имя")
    private String name;
    @Size(min = 1, max = 30, message = "слишком длинная или короткая фамилия")
    private String surname;

    @Min(value = 2, message = "оценка не может быть меньше 2")
    @Max(value = 5,message = " оценка не может быть больше 5")
    private int mark;

    public Student() {
    }

    public Student(int id,
                   @Size(min = 1, max = 30) String name,
                   @Size(min = 1, max = 30) String surname,
                   @Min(2) @Max(5) int mark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mark = mark;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
