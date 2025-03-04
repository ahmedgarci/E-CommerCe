package com.example.E_Commerce.Security;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

public class TokenConverter implements Converter<Jwt,AbstractAuthenticationToken> {


    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        return new JwtAuthenticationToken(source,Stream.concat(new JwtGrantedAuthoritiesConverter().convert(source).stream(),
        ExtractAuthorities(source).stream()
        ).collect(Collectors.toSet()));
        }
            private Collection<? extends GrantedAuthority> ExtractAuthorities(Jwt jwt) {
                var ressourceAccess = new HashMap<>(jwt.getClaim("resource_access"));
                var eternal = (Map<String,List<String>>)ressourceAccess.get("account");
                var roles = eternal.get("roles");
                
                return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.replace("-","_")))
                .collect(Collectors.toSet());

            }
        
        }