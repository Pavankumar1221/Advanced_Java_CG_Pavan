package com.lpu.TestMaven.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;
    private String name;
    private String email;
    private long phoneno;
    private String city;

    public User() {}

    public User(long id, String name, String email, long phoneno, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.city = city;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public long getPhoneno() { return phoneno; }
    public void setPhoneno(long phoneno) { this.phoneno = phoneno; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
