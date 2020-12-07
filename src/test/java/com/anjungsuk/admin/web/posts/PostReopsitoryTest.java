package com.anjungsuk.admin.web.posts;

import com.anjungsuk.admin.domain.posts.PostRepository;
import com.anjungsuk.admin.domain.posts.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostReopsitoryTest {
    @Autowired
    PostRepository postRepository; //PostRepository Bean을 자동으로 주입
    @After
    public void cleanUp(){
        postRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글"; //타이틀 지정
        String content = "테스트 본문"; //본문 내용 지정

        postRepository.save(Posts.builder() // 자동으로 postRepository를 조회하여 없을경우 insert문 생성 있을경우 해당 내용 Update
                .title(title)
                .content(content)
                .author("rusarmata@naver.com")
                .build());
        //when
        List<Posts> postsList = postRepository.findAll(); // DB Posts에 해당 내용이 있는지 전체 조회

        //then
        Posts posts = postsList.get(0); //postList를 가져온다
        assertThat(posts.getTitle()).isEqualTo(title); //getTitle과 title이 같을경우에 성공
        assertThat(posts.getContent()).isEqualTo(content);//getContent와 content가 같을경우에 성공
    }
}
