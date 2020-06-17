package com.rentshare.model;

import javax.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fk_username")
    private String fk_username;

    @Column(name = "fk_advertId")
    private Long fk_advertId;

    public Bid() { }

    public Bid(String fk_username, Long fk_advertId) {
        this.fk_username = fk_username;
        this.fk_advertId = fk_advertId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFk_username() {
        return fk_username;
    }

    public void setFk_username(String fk_username) {
        this.fk_username = fk_username;
    }

    public Long getFk_advertId() {
        return fk_advertId;
    }

    public void setFk_advertId(Long fk_advertId) {
        this.fk_advertId = fk_advertId;
    }
}
