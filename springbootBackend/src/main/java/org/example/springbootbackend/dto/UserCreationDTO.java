package org.example.springbootbackend.dto;


import lombok.Data;

/**
 * The type User creation dto.
 */
@Data
public class UserCreationDTO {
    private String username;
    private String password;
    private String email;

    /**
     * Instantiates a new User creation dto.
     *
     * @param username the username
     * @param password the password
     * @param email    the email
     */
    public UserCreationDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}