package com.emreuzun.bank.core.model;

import com.emreuzun.bank.core.annotation.Column;
import com.emreuzun.bank.core.annotation.Id;

import java.io.Serializable;

public class Issuer implements Serializable {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    public Issuer() {

    }

    public Issuer(long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
