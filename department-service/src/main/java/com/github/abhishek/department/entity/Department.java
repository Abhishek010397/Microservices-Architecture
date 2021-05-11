package com.github.abhishek.department.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//All the below annotations are used as we gonna make use of Getters ans Setters Along with Constructors
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    //Include our properties over here
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;//this is our primary key ion db and auto-generated
    private String departmentName;
    private  String departmentAddress;
    private  String departmentCode;
}
