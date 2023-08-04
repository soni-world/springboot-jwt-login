package com.soni.springbootjwtlogin.service;

import com.soni.springbootjwtlogin.dto.UserDetailDto;
import com.soni.springbootjwtlogin.model.UserInfo;
import com.soni.springbootjwtlogin.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repo.findByName(username);
        return userInfo.map(UserDetailDto::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username ));
    }
}
