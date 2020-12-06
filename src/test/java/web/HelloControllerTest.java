package web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 스프링부트 테스트와 jUnit 연결 어노테이션
@WebMvcTest(controllers = HelloController.class) // WEB에 중점된 어노테이션
public class HelloControllerTest {
    @Autowired // Spring Bean 자동 주입 어노테이션
    private MockMvc mvc; // 웹 API 테스트 어노테이션 스프링MVC 시작점

    @Test
    public void Hello가_리턴된다() throws Exception{ //Hello가_리턴한다 메소드에서 HelloController로 예외 전송
        String hello = "hello";

        mvc.perform(get("/hello")) // "/hello"로 HTTP GET방식 요청
                .andExpect(status().isOk()) // HTTP Header Status 검증
                .andExpect(content().string(hello)); // mvc.perform 결과값 검증 부 hello가 정상적으로 리턴되는지 확인
    }
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "name";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
            .param("name",name)
            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
                //.andExpect(jsonPath("$.name", is(name)))
                //.andExpect(jsonPath("$.amount", is(amount)));

    }
}
