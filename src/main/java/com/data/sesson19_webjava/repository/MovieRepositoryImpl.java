package com.data.sesson19_webjava.repository;

import com.data.sesson19_webjava.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Movie> result = null;
        try {
            tx = session.beginTransaction();
            result = session.createQuery("FROM Movie", Movie.class).list();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Movie findById(Long id) {
        Session session = sessionFactory.openSession();
        Movie movie = null;
        try {
            movie = session.get(Movie.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return movie;
    }

    @Override
    public void save(Movie movie) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(movie);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Movie movie) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(movie);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Movie movie = session.get(Movie.class, id);
            if (movie != null) {
                session.delete(movie);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
