package com.demo.sakila.service;

import com.demo.sakila.actor.Actor;
import com.demo.sakila.actor.ActorDto;
import com.demo.sakila.actor.ActorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MapService implements IMapService<ActorDto> {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public ActorDto getActorById(long id) {
        return convertToActorDto(Objects.requireNonNull(actorRepository.findById(id).orElse(null)));
    }

    // Method returns a List of ActorDto
    @Override
    public List<ActorDto> getAllActors() {
        final List<ActorDto> list = new CopyOnWriteArrayList<>();
        // for each actor in the actorRepository
        for (final Actor actor : actorRepository.findAll()) {
            // convert the given Actor object from actorRepository to an ActorDto object
            final ActorDto actorDto = convertToActorDto(actor);
            // add the actorDto to the List of ActorDto
            list.add(actorDto);
        }
        return list;
    }
    // private helper method to convert an Actor object to ActorDto object
    private @NotNull ActorDto convertToActorDto(@NotNull Actor actor) {
        // Declare all input variables from Actor object using getters
        final long actorId = actor.getActorId();
        final String actorFirstName = actor.getFirstName();
        final String actorLastName = actor.getLastName();
        final Date lastUpdate = actor.getLastUpdate();
        // Create new instance of Actor DTO using actorId as primary key
        final ActorDto actorDto = new ActorDto(actorId);
        // Use setters to input values into DTO and return the actorDto object
        actorDto.setFirstName(actorFirstName);
        actorDto.setLastName(actorLastName);
        actorDto.setLastUpdate(lastUpdate);
        return actorDto;
    }
}
