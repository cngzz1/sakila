package com.demo.sakila.service;

import java.util.List;

public interface IMapService<E> {
    E getActorById(long id);

    List<E> getAllActors();
}
