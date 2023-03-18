package com.harris.springsecuritydemo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.harris.springsecuritydemo.security.ApplicationUserRole.*;

@Repository
public class ApplicationUserDaoImpl implements ApplicationUserDao{

    private List<ApplicationUser> applicationUsers;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    @Override
    public Optional<ApplicationUser> selectApplicationByUsername(String username) {
        return getApplicationUsers().stream()
                .filter(applicationUser -> applicationUser.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }


    private List<ApplicationUser> getApplicationUsers(){
        applicationUsers = Arrays.asList(
                new ApplicationUser(STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "annasmith",
                true,
                true,
                        true,
                        true),

                new ApplicationUser(ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "linda",
                        true,
                        true,
                        true,
                        true),

                new ApplicationUser(ADMINTRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "tom",
                        true,
                        true,
                        true,
                        true)
                );

        return applicationUsers;
    }
}
