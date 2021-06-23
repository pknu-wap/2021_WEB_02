package com.web02.web;

import com.web02.service.posts.PostsService;
import com.web02.web.dto.PostsResponseDto;
import com.web02.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;    //model 을 사용하여 View에 데이터 전달
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")    //   첫화면 index+ 글 조회
    public String index(Model model){       //model: postService.findAllDesc()로 가져온 결과 posts로 index.mustache에 전달
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // src/main/resources/templates/index.mustache
    }

    @GetMapping("/posts/save")  //글 등록화면 이동
    public String postsSave(@RequestParam("file") MultipartFile files, PostsSaveRequestDto postsSaveRequestDto) {
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")    //글 수정화면 이동,id로 구분
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

    private class FilesDto {
    }
}
