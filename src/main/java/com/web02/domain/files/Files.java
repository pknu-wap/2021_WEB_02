package com.web02.domain.files;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Files {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String origFileName; //실제 파일이름

    @Column
    private String filename;    //업로드시 파일이름

    @Column
    private String filepath;    //파일    저장 위치

    @Builder
    public Files(String origFileName, String filename, String filepath){
        this.id=id;
        this.origFileName=origFileName;
        this.filename=filename;
        this.filepath=filepath;
    }

}
