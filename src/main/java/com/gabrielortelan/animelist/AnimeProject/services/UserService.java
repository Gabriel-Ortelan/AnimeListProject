package com.gabrielortelan.animelist.AnimeProject.services;

import com.gabrielortelan.animelist.AnimeProject.domain.User;
import com.gabrielortelan.animelist.AnimeProject.dto.UserDTO;
import com.gabrielortelan.animelist.AnimeProject.repository.UserRepository;
import com.gabrielortelan.animelist.AnimeProject.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        List<User> users = repository.findAll();
        User user = users.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
        if (user == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        if (id == null){
            throw new ObjectNotFoundException("Usuario não encontrado");
        }
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
