package com.example.basicboard.dto;

import com.example.basicboard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardResponseDto {

    private final Long id;

    private final String title;

    private final String contents;


    public static BoardResponseDto of(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
    }
}
