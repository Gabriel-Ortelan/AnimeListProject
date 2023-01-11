package com.gabrielortelan.animelist.AnimeProject.repository;

import com.gabrielortelan.animelist.AnimeProject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
