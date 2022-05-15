package com.demo.sakila.service;

import com.demo.sakila.actor.Actor;
import com.demo.sakila.actor.ActorDto;
import com.demo.sakila.actor.ActorRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MapService implements IMapService<ActorDto> {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ActorRepository userRepository;

    @Override
    public ActorDto getActorById(long id) {
        return convertToActorDto(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
    }

    @Override
    public List<ActorDto> getAllActors() {
        final List<ActorDto> list = new CopyOnWriteArrayList<>();
        for (final Actor user : userRepository.findAll()) {
            final ActorDto userDto = convertToActorDto(user);
            list.add(userDto);
        }
        return list;
    }

    private @NotNull ActorDto convertToActorDto(@NotNull Actor actor) {
        ActorDto actorLocationDTO = new ActorDto(actor.getActorId());
        actorLocationDTO.setFirstName(actor.getFirstName());
        actorLocationDTO.setLastName(actor.getLastName());
        return actorLocationDTO;
    }
}
