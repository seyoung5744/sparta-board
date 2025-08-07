package com.example.basicboard.service;

import com.example.basicboard.dto.MemberResponseDto;
import com.example.basicboard.dto.SignUpResponseDto;
import com.example.basicboard.entity.Member;
import com.example.basicboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) {
        Member member = Member.create(username, password, age);
        Member savedMember = memberRepository.save(member);
        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }

    public MemberResponseDto findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new MemberResponseDto(member.getId(), member.getUsername(), member.getAge());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Member member = memberRepository.findByIdOrElseThrow(id);

        if (!ObjectUtils.nullSafeEquals(member.getPassword(), oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        member.updatePassword(newPassword);
    }
}
