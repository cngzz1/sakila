package com.demo.sakila.service;

import com.demo.sakila.actor.Actor;
import com.demo.sakila.actor.ActorDto;
import com.demo.sakila.actor.ActorRepository;
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

    public ActorDto getUserLocation(long id) {
        return convertToUserLocationDTO(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
    }

    public List<ActorDto> getAllUsersLocation() {
        List<ActorDto> list = new CopyOnWriteArrayList<>();
        for (final Actor user : userRepository.findAll()) {
            final ActorDto userDto = convertToUserLocationDTO(user);
            list.add(userDto);
        }
        return list;
    }

    private ActorDto convertToUserLocationDTO(Actor user) {
        ActorDto userLocationDTO = new ActorDto(user.getActorId());
        userLocationDTO.setFirstName(user.getFirstName());
        userLocationDTO.setLastName(user.getLastName());
        return userLocationDTO;
    }
}
