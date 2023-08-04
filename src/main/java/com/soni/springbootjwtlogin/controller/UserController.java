package com.soni.springbootjwtlogin.controller;

import com.soni.springbootjwtlogin.dto.AuthRequest;
import com.soni.springbootjwtlogin.model.UserInfo;
import com.soni.springbootjwtlogin.service.JwtService;
import com.soni.springbootjwtlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/test")
    public String getWelcome(){
        return "Welcome Guest";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

    @DeleteMapping("/delete-user")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteUser(@RequestParam String username){
        return userService.deleteUser(username);
    }

    @PostMapping("/getToken")
    public String getAuthorizedAndToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
