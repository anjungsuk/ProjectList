package com.anjungsuk.admin.web;

import com.anjungsuk.admin.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 타입 컨트롤러 생성
public class HelloController { //HelloController 메소드 생성
    @GetMapping("/hello/dto") //HTTP GET 방식 API생성
    public HelloResponseDto hellodto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount); // 외부에서 넘어온 name, amount 값을 메소드 파라미터 저장
    }
}
