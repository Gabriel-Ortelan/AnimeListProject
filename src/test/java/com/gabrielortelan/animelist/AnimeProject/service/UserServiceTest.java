package com.gabrielortelan.animelist.AnimeProject.service;

import com.gabrielortelan.animelist.AnimeProject.domain.User;
import com.gabrielortelan.animelist.AnimeProject.repository.UserRepository;
import com.gabrielortelan.animelist.AnimeProject.services.UserService;
import com.gabrielortelan.animelist.AnimeProject.services.exception.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private String existingId;
    private String nonExistingId;
    private User user;
    List<User> userList = new ArrayList<>();

    @BeforeEach
    void setUp(){

        existingId = "2";
        nonExistingId = "6";

        userList = UserMock.createUserList();
        user = UserMock.createUser();
    }

    @Test
    @DisplayName("findById deve retornar um usuario com o id escolhido")
    void findByIdShouldReturnUserWhenIdExists(){
        when(userRepository.findAll()).thenReturn(userList);

        User result = userService.findById(existingId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(userList.get(0),result);
    }

    @Test
    @DisplayName("findAll deve retornar uma lista de usuarios")
    void findAllShouldReturnUserList(){
        when(userRepository.findAll()).thenReturn(userList);

        List<User> response = userService.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(3, response.size());
        Assertions.assertEquals(User.class, response.get(0).getClass());
    }

    @Test
    @DisplayName("findById deve retornar uma excessao quando id nao existir")
    void findByIdShouldThrowExceptionWhenIdNonExistis(){
        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            userService.findById(existingId);
        });
    }

    @Test
    @DisplayName("insert deve inserir um usuario")
    void insertShouldInsertAnUser(){
        when(userRepository.insert(user)).thenReturn(user);

        List<User> response = new ArrayList<>();
        response.add(user);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.get(0), user);
        Assertions.assertEquals(User.class, response.get(0).getClass());
    }

}
