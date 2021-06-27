package com.web02.web;


import com.web02.service.CommentsService;
import com.web02.service.PostsService;
import com.web02.web.dto.CommentsDto;
import com.web02.web.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final PostsService postService;
    private final CommentsService commentsService;

    @PostMapping("/api/v1/comments")
    public Long save(CommentsDto commentsDto){
         return commentsService.saveComments(commentsDto);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public Long delete(@PathVariable Long id) {
        commentsService.delete(id);
        return id;
    }

}

