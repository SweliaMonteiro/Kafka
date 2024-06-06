package com.example.dtos;

import com.example.models.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    private String username;

    private String email;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
