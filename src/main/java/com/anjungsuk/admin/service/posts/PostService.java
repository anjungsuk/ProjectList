package com.anjungsuk.admin.service.posts;

import com.anjungsuk.admin.domain.posts.PostRepository;
import com.anjungsuk.admin.domain.posts.Posts;
import com.anjungsuk.admin.web.dto.PostSaveRequestDto;
import com.anjungsuk.admin.web.dto.PostsResponseDto;
import com.anjungsuk.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }
    public PostsResponseDto findById (Long id){
        Posts entity = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id =" +id));
        return new PostsResponseDto(entity);
    }
}
