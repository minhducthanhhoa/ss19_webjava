package com.data.sesson19_webjava.service;

import com.data.sesson19_webjava.entity.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> getAll();
    Theater getById(Long id);
    void save(Theater theater);
    void update(Theater theater);
    void deleteOrDeactivate(Long id);
}
