package com.web02.web.domain.comments;


import com.web02.domain.comments.Comments;
import com.web02.domain.comments.CommentsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;

    @After
    public void cleanup(){
        commentsRepository.deleteAll();
    }

    @Test
    public void 댓글달기(){
        //given
        Long commentId= 11L;
        String content="댓글 내용";
        commentsRepository.save(Comments.builder()
                .commentId(commentId)
                .content(content)
                .build());
        //when
        List<Comments> commentsList=commentsRepository.findAll();
        //then
        Comments comments = commentsList.get(0);
        assertThat(comments.getCommentId()).isEqualTo(commentId);
        assertThat(comments.getContent()).isEqualTo(content);
    }

}
