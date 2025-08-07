package com.example.basicboard.service;

import com.example.basicboard.dto.SignUpResponseDto;
import com.example.basicboard.entity.Member;
import com.example.basicboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) {
        Member member = Member.create(username, password, age);
        Member savedMember = memberRepository.save(member);
        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }
}
