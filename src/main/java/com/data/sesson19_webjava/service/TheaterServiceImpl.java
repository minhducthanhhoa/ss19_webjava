package com.data.sesson19_webjava.service;

import com.data.sesson19_webjava.entity.Theater;
import com.data.sesson19_webjava.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService{
    @Autowired
    private TheaterRepository repository;

    @Override
    public List<Theater> getAll() {
        return repository.findAll();
    }

    @Override
    public Theater getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Theater theater) {
        repository.save(theater);
    }

    @Override
    public void update(Theater theater) {
        repository.update(theater);
    }

    @Override
    public void deleteOrDeactivate(Long id) {
        repository.deleteOrDeactivate(id);
    }
}
