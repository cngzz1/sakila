package com.demo.sakila.actor;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

public class ActorDto implements Serializable {
    private final Long actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    @Contract(pure = true)
    public ActorDto(Long actorId) {
        this.actorId = actorId;
    }

    @Contract(pure = true)
    public ActorDto(Long actorId, String firstName, String lastName, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public long getActorId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDto entity = (ActorDto) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, lastUpdate);
    }

    @Override
    public String toString() {
        return "%s(actorId = %d, firstName = %s, lastName = %s, lastUpdate = %s)".formatted(getClass().getSimpleName(), actorId, firstName, lastName, lastUpdate);
    }
}
