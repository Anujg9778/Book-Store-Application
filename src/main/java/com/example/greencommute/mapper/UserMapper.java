package com.example.greencommute.mapper;

import com.example.greencommute.dto.UserDTO;
import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;

public class UserMapper {

    public User convertToUser(UserDTO userDTO){

        User user=new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public UserDTO convertToUserDTO(User user){
        UserDTO userDTO=new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public UserDTO convertToUserDTOFromAuthority(Authorities authority){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName(authority.getUserName());
        userDTO.setPassword(authority.getUser().getPassword());
        userDTO.setRole(authority.getAuthority());
        return userDTO;
    }

}
