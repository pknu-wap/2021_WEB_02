// entity 클래스와 유사 하지만 entity를 req,res 클래스로 사용 xxx,entity클래스는 너무 큰 변경
//view Layer-dto
//DB layer-entity
package com.web02.web.dto;

import com.web02.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;



    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)

                .build();
    }


}