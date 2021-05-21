package com.web02.springboot.web.dto;

import com.web02.springboot.domain.Files.Files;
import com.web02.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsFileDto
{
    private Long id;
    private String origFileName;
    private String filename;
    private String filepath;

    public Files toEntity() {
        return Files.builder()
                .origFileName(origFileName)
                .filename(filename)
                .filepath(filepath)
                .build();
    }
    @Builder
    public PostsFileDto(Long id, String origFileName, String filename, String filepath){
        this.id=id;
        this.origFileName=origFileName;
        this.filename=filename;
        this.filepath=filepath;
    }
}
