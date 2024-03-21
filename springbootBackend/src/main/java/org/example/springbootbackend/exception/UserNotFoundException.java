package org.example.springbootbackend.exception;


/**
 * The type User not found exception.
 */
public class UserNotFoundException extends RuntimeException{

    /**
     * Instantiates a new User not found exception.
     *
     * @param username the username
     */
    public UserNotFoundException(String username) {
        super(String.format("User, %s, not found", username));
    }
}