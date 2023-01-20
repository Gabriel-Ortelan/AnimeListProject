package com.gabrielortelan.animelist.AnimeProject.services;

import com.gabrielortelan.animelist.AnimeProject.domain.Movie;
import com.gabrielortelan.animelist.AnimeProject.domain.User;
import com.gabrielortelan.animelist.AnimeProject.dto.MovieDTO;
import com.gabrielortelan.animelist.AnimeProject.dto.UserDTO;
import com.gabrielortelan.animelist.AnimeProject.repository.MovieRepository;
import com.gabrielortelan.animelist.AnimeProject.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie findById(String id){
        List<Movie> movies = repository.findAll();
        Movie movie = movies.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
        if (movie == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return movie;
    }

    public Movie insert(Movie obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        if (id == null){
            throw new ObjectNotFoundException("Usuario não encontrado");
        }
        repository.deleteById(id);
    }

    public Movie fromDTO(MovieDTO objDTO){
        return new Movie(objDTO.getName(), objDTO.getName());
    }
}
