package org.example.springbootbackend.mapper;


import org.example.springbootbackend.dto.UserCreationDTO;
import org.example.springbootbackend.dto.UserDTO;
import org.example.springbootbackend.model.User;
import org.springframework.stereotype.Component;

/**
 * The type User mapper.
 */
@Component
public class UserMapper {

    /**
     * To user user.
     *
     * @param userDTO the user dto
     * @return the user
     */
    public User toUser(UserCreationDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
    }

    /**
     * To user dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
    public UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail());
    }

}