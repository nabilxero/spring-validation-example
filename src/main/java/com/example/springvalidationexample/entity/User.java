package com.example.springvalidationexample.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor(staticName = "userBuild")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private Integer age;
    private String nationality;


}
