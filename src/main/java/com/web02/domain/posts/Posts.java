package com.web02.domain.posts;

import com.web02.domain.BaseTimeEntity;
import com.web02.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//setter x
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @OneToMany(mappedBy = "posts")  //N:1 양방향연결 , 1:N x
    private List<Comments> comments=new ArrayList<>();


    @Builder
    public Posts(String title, String content, String author,List<Comments> comments) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments=comments;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}