package org.example.springbootbackend.dto;

import lombok.Data;

/**
 * The type User dto.
 */
@Data
public class UserDTO {
    private String username;
    private String password;

    /**
     * Instantiates a new User dto.
     *
     * @param username the username
     * @param password the password
     */
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}