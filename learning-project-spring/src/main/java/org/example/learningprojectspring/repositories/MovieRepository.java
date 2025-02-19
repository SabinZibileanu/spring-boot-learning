package org.example.learningprojectspring.repositories;

import org.example.learningprojectspring.moviestore.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

