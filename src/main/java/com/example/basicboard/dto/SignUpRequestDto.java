package com.example.basicboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {

    private final String username;

    private final String password;

    private final Integer age;

}
