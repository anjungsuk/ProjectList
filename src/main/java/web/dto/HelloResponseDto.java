package web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@Getter //선언된 필드의 get메소드 생성
//@RequiredArgsConstructor // @Autowired를 사용 하지 않고 자동으로 생성자 생성 어노테이션
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
