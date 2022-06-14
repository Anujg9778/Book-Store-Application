package com.example.greencommute.mapper;

import com.example.greencommute.dto.UserDTO;
import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {

    @Mock
    UserMapper userMapper;

    @BeforeEach
    void setUp(){
        userMapper=new UserMapper();
    }


    @Test
    void convertToUserTest(){
        UserDTO userDTO=new UserDTO("shiv","shiv123","User");
        User user=new User("shiv","shiv123",1);

        user=userMapper.convertToUser(userDTO);

        assertEquals(userDTO.getUserName(),user.getUserName());
        assertEquals(userDTO.getPassword(),user.getPassword());
        assertEquals(userDTO.getRole(),user.getRole());
    }

    @Test
    void convertToUserDTOTest(){
        UserDTO userDTO=new UserDTO("shiv","shiv123","User");
        User user=new User("shiv","shiv123",1);
        user.setRole("User");

        userDTO=userMapper.convertToUserDTO(user);

        assertEquals(userDTO.getUserName(),user.getUserName());
        assertEquals(userDTO.getPassword(),user.getPassword());
        assertEquals(userDTO.getRole(),user.getRole());

    }

    @Test
    void convertToUserDTOFromAuthority(){

        User user=new User("shiv","shiv123",1);
        user.setRole("User");
        UserDTO userDTO=new UserDTO("shiv","shiv123","User");
        Authorities authority=new Authorities("shiv","shiv123");
        authority.setUser(user);

        userDTO=userMapper.convertToUserDTOFromAuthority(authority);

        assertEquals(userDTO.getUserName(),authority.getUserName());
        assertEquals(userDTO.getRole(),authority.getAuthority());
        assertEquals(userDTO.getPassword(),authority.getUser().getPassword());


    }

}