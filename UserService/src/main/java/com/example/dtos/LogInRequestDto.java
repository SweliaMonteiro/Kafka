package com.example.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LogInRequestDto {

    private String username;

    private String email;

    private String password;

}
