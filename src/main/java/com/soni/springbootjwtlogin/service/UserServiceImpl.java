package com.soni.springbootjwtlogin.service;

import com.soni.springbootjwtlogin.model.UserInfo;
import com.soni.springbootjwtlogin.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public String addUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "added successfully";
    }

    @Override
    public String deleteUser(String userName){
        Optional<UserInfo> user = repo.findByName(userName);
        if(!user.isPresent())
            throw new UsernameNotFoundException("User not found");
        repo.deleteById(user.get().getId());

        return "Deleted successfully";
    }
}
