package com.web02.springboot.domain.Files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web02.springboot.domain.Files.Files;
import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Long> {


}
