package com.web02.web.dto;

import com.web02.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class CommentsDto {
    private Long id;
    private Long commentId;
    private String content;

    @Builder
    public CommentsDto(Long id, Long commentsId, String content){
        this.id=id;
        this.commentId=commentsId;
        this.content=content;
    }

    public Comments toEntity(){
        return Comments.builder()
                .id(id)
                .commentId(commentId)
                .content(content)
                .build();
    }
}
