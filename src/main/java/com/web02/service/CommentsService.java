package com.web02.service;

import com.web02.domain.comments.Comments;
import com.web02.domain.comments.CommentsRepository;
import com.web02.domain.files.FilesRepository;
import com.web02.domain.posts.Posts;
import com.web02.domain.posts.PostsRepository;
import com.web02.web.dto.CommentsDto;
import com.web02.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Transactional
    public Long savecomments(CommentsDto commentsDto){
        return commentsRepository.save(commentsDto.toEntity()).getId();
    }

    @Transactional
    public void delete (Long id) {
        Comments comments=commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        commentsRepository.delete(comments);
    }

}
