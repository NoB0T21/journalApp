package com.edigest.journalApp.config;

import com.edigest.journalApp.modules.auth.UserEntity;
import com.edigest.journalApp.modules.auth.UserEntityRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final UserEntityRepo userEntityRepo;

  public CustomUserDetailsService(UserEntityRepo userEntityRepo) {
    this.userEntityRepo = userEntityRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String email)
          throws UsernameNotFoundException {

    UserEntity user = userEntityRepo.findByEmail(email);
    if (user == null) user = userEntityRepo.findByUserName(email);

    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return User.withUsername(user.getUserName())
            .password(user.getPassWord())
            .authorities("ROLE_USER")
            .build();
  }
}
