package com.gabrielortelan.animelist.AnimeProject.repository;

import com.gabrielortelan.animelist.AnimeProject.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
