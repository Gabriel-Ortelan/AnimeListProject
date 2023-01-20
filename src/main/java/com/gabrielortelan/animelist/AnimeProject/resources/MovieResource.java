package com.gabrielortelan.animelist.AnimeProject.resources;

import com.gabrielortelan.animelist.AnimeProject.domain.Movie;
import com.gabrielortelan.animelist.AnimeProject.domain.User;
import com.gabrielortelan.animelist.AnimeProject.dto.MovieDTO;
import com.gabrielortelan.animelist.AnimeProject.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "movies")
public class MovieResource {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll(){
        List<Movie> list = service.findAll();
        List<MovieDTO> listDto = list.stream().map(item -> new MovieDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity findById(@PathVariable String id){
        Movie movie = service.findById(id);
        return ResponseEntity.ok().body(new MovieDTO(movie));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MovieDTO objDto){
        Movie movie = service.fromDTO(objDto);
        movie = service.insert(movie);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
