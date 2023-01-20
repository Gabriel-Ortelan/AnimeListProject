package com.gabrielortelan.animelist.AnimeProject.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "movie")
public class Movie implements Serializable {

    @Id
    private String id;
    private String name;
    private String genre;

    public Movie(){};

    public Movie(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Movie(String name, String genre) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
