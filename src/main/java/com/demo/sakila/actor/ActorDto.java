package com.demo.sakila.actor;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ActorDto implements Serializable {
    private final long actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

    public ActorDto(long actorId) {
        this.actorId = actorId;
    }

    @Contract(pure = true)
    public ActorDto(long actorId, String firstName, String lastName, Timestamp lastUpdate) {
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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
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
