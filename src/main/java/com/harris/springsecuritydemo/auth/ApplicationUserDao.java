package com.harris.springsecuritydemo.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    public Optional<ApplicationUser> selectApplicationByUsername(String username);
}
