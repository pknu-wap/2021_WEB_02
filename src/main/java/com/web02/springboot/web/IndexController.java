package com.web02.springboot.web;

import com.web02.springboot.service.posts.PostsService;
import com.web02.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;    //model 을 사용하여 View에 데이터 전달
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")    //글 수정화면 이동,id로 구분
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
