package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;

@Entity
@NamedQuery(name = "User.withNameAndAddressNamedQuery",query = "select u from User u  where u.name=?1 and u.address=?2")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private String address;

    private Timestamp createDate;

    public User() {
    }

    public User(String name, String sex, Integer age, String address, Timestamp createDate) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
