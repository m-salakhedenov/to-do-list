package com.demo.todo.security;

import com.demo.todo.model.AppUser;
import com.demo.todo.repository.AppUserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

  private final AppUserRepository appUserRepository;

  public AppUserDetailsService(AppUserRepository appUserRepository) {
    this.appUserRepository = appUserRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = appUserRepository.findByUsername(username)
                                    .orElseThrow(() -> new UsernameNotFoundException(
                                        "Failed to find user with username: " + username));

    return new User(
        user.getUsername(),
        user.getPassword(),
        true,
        true,
        true,
        true,
        AuthorityUtils.createAuthorityList("USER")
    );
  }

}
