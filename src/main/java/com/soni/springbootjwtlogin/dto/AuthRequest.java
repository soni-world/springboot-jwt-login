package com.soni.springbootjwtlogin.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String UserName;
    private String password;
}
