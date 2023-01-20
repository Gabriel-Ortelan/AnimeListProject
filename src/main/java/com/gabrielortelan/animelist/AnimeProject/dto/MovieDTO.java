package com.gabrielortelan.animelist.AnimeProject.dto;

import com.gabrielortelan.animelist.AnimeProject.domain.Movie;

import java.io.Serializable;
import java.util.Optional;

public class MovieDTO {

    private String name;
    private String genre;

    public MovieDTO(){};

    public MovieDTO(Movie obj) {
        name = obj.getName();
        genre = obj.getGenre();
    }

    public MovieDTO(Optional<Movie> item) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
