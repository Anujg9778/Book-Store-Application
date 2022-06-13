package com.example.greencommute.mapper;

import com.example.greencommute.dto.UserDTO;
import com.example.greencommute.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {

    @Mock
    ModelMapper modelMapper;

    @Mock
    UserMapper userMapper;

    @BeforeEach
    void setUp(){
        userMapper=new UserMapper(modelMapper);
    }


    @Test
    void convertToUserTest(){
        UserDTO userDTO=new UserDTO("shiv","shiv123","User");
        User user=new User("shiv","shiv123",1);

        UserMapper user1=Mockito.spy(new UserMapper(modelMapper));
        Mockito.doReturn(user).when(user1)
                        .convertToUser(userDTO);

        Assertions.assertEquals(user,user1.convertToUser(userDTO));
    }



}