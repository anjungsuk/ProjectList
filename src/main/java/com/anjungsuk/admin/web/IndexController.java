package com.anjungsuk.admin.web;

import com.anjungsuk.admin.service.posts.PostService;
import com.anjungsuk.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postService.findAllDesc()); //postService 에서 가져온 객체 결과를 index.mustache에 전달 한다.
        return "index";
    }
    @GetMapping("/posts/save") //Get 방식 posts-save.mustache 호출
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postService.findById(id); //dto 갹채룰 생성햐여 postsResponceDto내 id값을 조회한다.
        model.addAttribute("post", dto);
        return "posts-update";

    }
}
