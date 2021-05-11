package com.web02.test.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Getter //선언된 모든 필드 get메소드 생성
@RequiredArgsConstructor// 선언된 모든 final 필드가 포함된 생성자 생성

public class HelloResponseDto {
    private final String name;
    private final int amount;
}

