package com.marcos.saguier.msagecalc.entity;

/**
 * Represents the age of a person
 */
public class AgeDTO {

    private Integer age;

    public AgeDTO() {
        //No-args constructor
    }

    public AgeDTO(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AgeDTO{" +
                "age=" + age +
                '}';
    }
}
