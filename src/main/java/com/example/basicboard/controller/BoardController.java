package com.example.basicboard.controller;

import com.example.basicboard.dto.BoardResponseDto;
import com.example.basicboard.dto.CreateBoardRequestDto;
import com.example.basicboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {
        List<BoardResponseDto> boardResponses = boardService.findAll();
        return new ResponseEntity<>(boardResponses, HttpStatus.OK);
    }
}
