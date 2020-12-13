package com.anjungsuk.admin.web;

import com.anjungsuk.admin.service.posts.PostService;
import com.anjungsuk.admin.web.dto.PostSaveRequestDto;
import com.anjungsuk.admin.web.dto.PostsResponseDto;
import com.anjungsuk.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postService.findById(id); //get방식으로/api/v1/posts/{id}값이 요청오면 postService상 id를 찾아 반환한다
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }
}
