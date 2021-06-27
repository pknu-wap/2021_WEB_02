package com.web02.domain.comments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web02.domain.BaseTimeEntity;
import com.web02.domain.posts.Posts;
import com.web02.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    @Builder
    public Comments(Long id, Long commentId, String content){
        this.id=id;
        this.commentId=commentId;
        this.content=content;
    }

}
