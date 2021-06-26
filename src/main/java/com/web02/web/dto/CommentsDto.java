package com.web02.web.dto;

import com.web02.domain.comments.Comments;
import lombok.Getter;
import lombok.Setter;


@Getter
public class CommentsDto {
    private String content;
    private Long userNo;
    private Long postNo;
    private String created_by;

}
