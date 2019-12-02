package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "addrbook")
public class AddrBook {
    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "job")
    private String job;

    @Column(name = "email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
