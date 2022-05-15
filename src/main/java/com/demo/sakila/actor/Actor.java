package com.demo.sakila.actor;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long actorId;


    private String firstName;
    private String lastName;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date lastUpdate;


    public Long getActorId() {
        return actorId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
