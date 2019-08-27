/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci6110.ci6110.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author pk
 */

@Entity
public class Employee {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String fname;
    private String surname; 
    private float salary;
    
    
    
    public Employee() {
    }
    

    public Employee(String fname, String surname, float salary) {
        this.fname = fname;
        this.surname = surname;
        this.salary = salary;
    } 


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", fname=" + fname + ", surname=" + surname + ", salary=" + salary + '}';
    }
    
    
    
    
    
    
}
