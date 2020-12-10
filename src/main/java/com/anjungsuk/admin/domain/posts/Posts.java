package com.anjungsuk.admin.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //롬복 어노테이션 getter 메소드 자동 생성
@NoArgsConstructor //롬복 어노테이션 기본 생성자 자동추가
@Entity //jpa 어노테이션 테이블과 링크되는 클래스
public class Posts { //DB Query 생성 클래스
    @Id // 하단의 생성자들을 통한 pk(primary key)를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key 생성규칙을 나타냄
    private Long Id;
    @Column(length = 500, nullable = false) // 테이블 칼럼 생성
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false) // 테이블 칼럼 생성
    private String content;

    private String author;

    @Builder// Builder 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
