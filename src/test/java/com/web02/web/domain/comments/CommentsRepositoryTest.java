package com.web02.web.domain.comments;


import com.web02.domain.comments.Comments;
import com.web02.domain.comments.CommentsRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
    Long commentId= 11L;
    String content="댓글 내용";
    @Test
    public void 댓글달기(){
        //given

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

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now= LocalDateTime.of(2021,6,26,10,30,0);
        commentsRepository.save(Comments.builder()
                .commentId(commentId)
                .content(content)
                .build());
        //when
        List<Comments> commentsList=commentsRepository.findAll();

        //then
        Comments comments=commentsList.get(0);

        System.out.println(">>>>>>>>>>>createDate="+comments.getCreatedDate()+", modifiedDate="+comments.getModifiedDate());

        Assertions.assertThat(comments.getCreatedDate()).isAfter(now);
        Assertions.assertThat(comments.getModifiedDate()).isAfter(now);
    }

}
