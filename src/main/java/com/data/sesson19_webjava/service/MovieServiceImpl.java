package com.data.sesson19_webjava.service;

import com.data.sesson19_webjava.entity.Movie;
import com.data.sesson19_webjava.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepo;

    @Override
    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    @Override
    public Movie getById(Long id) {
        return movieRepo.findById(id);
    }

    @Override
    public void save(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public void update(Movie movie) {
        movieRepo.update(movie);
    }

    @Override
    public void deleteOrDeactivate(Long id) {
        Movie movie = movieRepo.findById(id);
        boolean hasSchedule = false;
        if (hasSchedule) {
            movie.setStatus(false);
            movieRepo.update(movie);
        } else {
            movieRepo.delete(id);
        }
    }
}
