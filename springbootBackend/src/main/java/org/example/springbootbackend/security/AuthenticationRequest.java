package org.example.springbootbackend.security;


import lombok.*;


/**
 * The type Authentication request.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NonNull
    private String username;


    @NonNull
    private String password;
}