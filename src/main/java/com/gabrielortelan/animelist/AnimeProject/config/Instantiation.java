package com.gabrielortelan.animelist.AnimeProject.config;

import com.gabrielortelan.animelist.AnimeProject.domain.Movie;
import com.gabrielortelan.animelist.AnimeProject.domain.User;
import com.gabrielortelan.animelist.AnimeProject.repository.MovieRepository;
import com.gabrielortelan.animelist.AnimeProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void run(String ...args) throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        movieRepository.deleteAll();


        User maria = new User(null, "Maria Brown","maria@gmail.com");
        User alex = new User(null,"Alex Green","alex@gmail.com");
        User bob = new User(null,"Bob Grey","bob@gmail.com");

        Movie avengers = new Movie(null,"Avengers","action");
        Movie avengers2 = new Movie(null,"Avengers: Age of Ultron","action");
        Movie avengers3 = new Movie(null,"Avengers: Infinity War","action");
        Movie avengers4 = new Movie(null,"Avengers: Endgame","action");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        movieRepository.saveAll(Arrays.asList(avengers,avengers2,avengers3,avengers4));


    }
}
