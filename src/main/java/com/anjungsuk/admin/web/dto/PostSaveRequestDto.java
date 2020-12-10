package com.anjungsuk.admin.web.dto;

import com.anjungsuk.admin.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto { // DB에 사용되는 생성자 클래스
    private String title; //private 문자열 제목 생성
    private String content; // private 본문 생성
    private String author; // private 기타 생성

    @Builder //생성자를 대신 할 Builder 어노테이션 사용
    public PostSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
