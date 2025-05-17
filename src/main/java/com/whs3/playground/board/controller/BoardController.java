package com.whs3.playground.board.controller;

import com.whs3.playground.board.dto.BoardResponseDto;
import com.whs3.playground.board.dto.BoardRequestsDto;
import com.whs3.playground.board.dto.SuccessResponseDto;
import com.whs3.playground.board.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/posts")
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
    }

    @PostMapping("/api/post")
    public BoardResponseDto createPost(@RequestBody BoardRequestsDto requestsDto) {
        return boardService.createPost(requestsDto);
    }

    @GetMapping("/api/post/{id}")
    public BoardResponseDto getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    public BoardResponseDto updatePost(@PathVariable Long id, @RequestBody BoardRequestsDto requestsDto) throws Exception {
        return boardService.updatePost(id, requestsDto);
    }

    @DeleteMapping("/api/post/{id}")
    public SuccessResponseDto deletePost(@PathVariable Long id, @RequestBody BoardRequestsDto requestsDto) throws Exception {
        return boardService.deletePost(id, requestsDto);
    }
}