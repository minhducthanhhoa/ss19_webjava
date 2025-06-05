package com.data.sesson19_webjava.repository;

import com.data.sesson19_webjava.entity.Theater;

import java.util.List;

public interface TheaterRepository {
    List<Theater> findAll();
    Theater findById(Long id);
    void save(Theater theater);
    void update(Theater theater);
    void deleteOrDeactivate(Long id);
}
