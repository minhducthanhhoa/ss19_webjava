package com.data.sesson19_webjava.repository;

import com.data.sesson19_webjava.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
    Movie findById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void delete(Long id);
}
