package com.example.basicboard.controller;

import com.example.basicboard.dto.BoardResponseDto;
import com.example.basicboard.dto.CreateBoardRequestDto;
import com.example.basicboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto request) {
        BoardResponseDto boardResponseDto = boardService.save(request.getTitle(), request.getContents(), request.getUsername());
        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }
}
