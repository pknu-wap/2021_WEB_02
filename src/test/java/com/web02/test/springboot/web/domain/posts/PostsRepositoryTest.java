// save, findAll 기능 수행
package com.web02.test.springboot.web.domain.posts;

import com.web02.test.springboot.domain.posts.Posts;
import com.web02.test.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;


import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  //단위테스트가 끝날때마다 수행되는 메소드 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시물";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("ksy13001@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll(); // posts에 있는 모든 데이터 조회
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now= LocalDateTime.of(2021,5,10,0,0,0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

       //then
       Posts posts=postsList.get(0);

       System.out.println(">>>>>>>>>>>createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

       assertThat(posts.getCreatedDate()).isAfter(now);
       assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
