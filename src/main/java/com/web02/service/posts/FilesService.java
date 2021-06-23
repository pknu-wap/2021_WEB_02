package com.web02.service.posts;

import com.web02.domain.files.FilesRepository;
import com.web02.web.dto.FilesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FilesService {
    private final FilesRepository filesRepository;


    @Transactional
    public Long saveFiles(FilesDto filesDto){
    return filesRepository.save(filesDto.toEntity()).getId();
    }

}
