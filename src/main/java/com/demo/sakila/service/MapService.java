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
public class MapService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ActorRepository userRepository;

    public ActorDto getActorById(long id) {
        return convertToUserLocationDTO(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
    }

    public List<ActorDto> getAllActors() {
        final List<ActorDto> list = new CopyOnWriteArrayList<>();
        for (final Actor actor : userRepository.findAll()) {
            final ActorDto userDto = convertToUserLocationDTO(actor);
            list.add(userDto);
        }
        return list;
    }

    private @NotNull ActorDto convertToUserLocationDTO(@NotNull Actor actor) {
        final ActorDto userLocationDTO = new ActorDto(actor.getActorId());
        userLocationDTO.setFirstName(actor.getFirstName());
        userLocationDTO.setLastName(actor.getLastName());
        return userLocationDTO;
    }
}
