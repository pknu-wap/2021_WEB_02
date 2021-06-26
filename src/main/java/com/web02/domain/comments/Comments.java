package com.web02.domain.comments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web02.domain.BaseTimeEntity;
import com.web02.domain.posts.Posts;
import com.web02.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long commnetId;

    @Column(nullable = false)
    private String contens;

    @Column(nullable = false)
    private String created_by;




}
