package com.web02.service;

import com.web02.domain.files.Files;
import com.web02.domain.files.FilesRepository;
import com.web02.domain.posts.Posts;
import com.web02.domain.posts.PostsRepository;
import com.web02.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FilesService {
    private final  FilesRepository filesRepository;

    @Transactional
    public Long savefile(FilesDto filesDto){
        return  filesRepository.save(filesDto.toEntity()).getId();
    }

    @Transactional
    public FilesDto getFile(Long id) {
        Files file = filesRepository.findById(id).get();

        FilesDto fileDto = FilesDto.builder()
                .id(id)
                .origFileName(file.getOrigFileName())
                .filename(file.getFilename())
                .filepath(file.getFilepath())
                .build();
        return fileDto;
    }
}
