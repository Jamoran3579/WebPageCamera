package com.example;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final String USER_NAME = "Jason";
  private static final String PASSWORD = "Jayo3579";
  private final PasswordEncoder passwordEncoder;

  public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (USER_NAME.equals(username)) {
      return org.springframework.security.core.userdetails.User.builder()
          .username(USER_NAME)
          .password(passwordEncoder.encode(PASSWORD))
          .roles("USER")
          .build();
    } else {
      throw new UsernameNotFoundException("User not found");
    }
  }
}
