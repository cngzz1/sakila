package com.demo.sakila.service;

import java.util.List;

interface IMapService<E> {
    E getActorById(long id);

    List<E> getAllActors();
}
