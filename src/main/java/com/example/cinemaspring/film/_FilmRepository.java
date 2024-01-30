package com.example.cinemaspring.film;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
//@Transactional
public class _FilmRepository {

    private final EntityManager entityManager;

    public _FilmRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Film> findAll() {
        return entityManager.createQuery("SELECT f FROM Film f", Film.class).getResultList();
    }

    public Film save(Film film) {
        entityManager.persist(film);
        entityManager.flush(); //Chasse d'eau
        return film;
    }

//    public Film findById(Integer id ) {
//        return entityManager.find(Film.class, id);
//    }

    public Optional<Film> findById(Integer id) {
        return Optional.ofNullable(
                entityManager.find(Film.class, id)
        );
    }

    public Film update(Film film) {
        return entityManager.merge(film);
    }

    public void delete(Film film) {
        entityManager.remove(film);
    }
}
