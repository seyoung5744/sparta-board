package com.example.basicboard.controller;

import com.example.basicboard.dto.SignUpRequestDto;
import com.example.basicboard.dto.SignUpResponseDto;
import com.example.basicboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto request) {

        SignUpResponseDto signUpResponseDto = memberService.signUp(request.getUsername(), request.getPassword(), request.getAge());
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }
}
