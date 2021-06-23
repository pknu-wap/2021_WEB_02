package com.web02.web.dto;

import com.web02.domain.files.Files;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FilesDto
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
    public FilesDto(Long id, String origFileName, String filename, String filepath){
        this.id=id;
        this.origFileName=origFileName;
        this.filename=filename;
        this.filepath=filepath;
    }
}
