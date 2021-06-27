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
    private String author;
    private String content;

    @Builder
    public CommentsDto(String content, String author){
        this.content=content;
        this.author=author;
    }

    public Comments toEntity(){
        return Comments.builder()
                .content(content)
                .author(author)
                .build();
    }
}
