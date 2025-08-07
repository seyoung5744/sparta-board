package com.example.basicboard.service;

import com.example.basicboard.dto.BoardResponseDto;
import com.example.basicboard.dto.BoardWithAgeResponseDto;
import com.example.basicboard.entity.Board;
import com.example.basicboard.entity.Member;
import com.example.basicboard.repository.BoardRepository;
import com.example.basicboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardResponseDto save(String title, String contents, String username) {

        Member member = memberRepository.findByUsernameOrElseThrow(username);

        Board board = Board.create(title, contents);
        board.setMember(member);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

    public List<BoardResponseDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(BoardResponseDto::of)
                .toList();
    }

    public BoardWithAgeResponseDto findById(Long id) {
        Board board = boardRepository.findByIdOrElseThrow(id);
        Member writer = board.getMember();
        return new BoardWithAgeResponseDto(board.getTitle(), board.getContents(), writer.getAge());
    }
}
