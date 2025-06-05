package com.data.sesson19_webjava.repository;

import com.data.sesson19_webjava.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Theater> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Theater", Theater.class).list();
        }
    }

    @Override
    public Theater findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Theater.class, id);
        }
    }

    @Override
    public void save(Theater theater) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(theater);
            tx.commit();
        }
    }

    @Override
    public void update(Theater theater) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(theater);
            tx.commit();
        }
    }

    @Override
    public void deleteOrDeactivate(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Theater t = session.get(Theater.class, id);
            // Giả sử có method check lịch chiếu (chưa viết)
            boolean hasSchedule = false;
            if (hasSchedule) {
                t.setStatus(false);
                session.update(t);
            } else {
                session.delete(t);
            }
            tx.commit();
        }
    }
}
