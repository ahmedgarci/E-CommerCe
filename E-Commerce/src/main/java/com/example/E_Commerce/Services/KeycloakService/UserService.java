package com.example.E_Commerce.Services.KeycloakService;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    public String getConnectedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof JwtAuthenticationToken jwtToken){
            String userId = jwtToken.getToken().getClaim("sub"); 
            return userId;
        }
        return null;


    }
    
}
