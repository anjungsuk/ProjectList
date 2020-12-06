package web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복기능_테스트() {


    //given
    String name = "test";
    int amount = 1000;

    //when
    HelloResponseDto dto = new HelloResponseDto(name, amount);//HelloResponseDto 객체 생성 후 name amount 데이터 타입 생성

    //then
    assertThat(dto.getName()).isEqualTo(name); // assertThat(name) isEqualTo(name) 비교 후 전송
    assertThat(dto.getAmount()).isEqualTo(amount); // assertThat(name) isEqualTo(name) 비교 후 전송

}
}

