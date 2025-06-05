package com.data.sesson19_webjava.service;

import com.data.sesson19_webjava.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    Movie getById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void deleteOrDeactivate(Long id);
}
