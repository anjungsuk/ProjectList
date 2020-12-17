package com.anjungsuk.admin.config.auth;

import com.anjungsuk.admin.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 활성화 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserTypesOAuth2UserService customUserTypesOAuth2UserService; // CustomUserTypesOAuth2UserService 객체 생성

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable() //Spring Security 설정 활성화
                .headers().frameOptions().disable() // h2-console화면을 사용 위한 disable
                .and()
                .authorizeRequests() // URL별 권한 관리 설정 옵션 시작
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //권한 관리 대상을 지정하는 옵션
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //antMatchers는 authorizeRequest() 함수 선언이 되어야지만 사용 가능하다. USER권한만 가진 사람만이 api/v1/** 사용 가능
                .anyRequest().authenticated()//설정 값 이외의 URL를 나타낸다
                .and()
                .logout()
                .logoutSuccessUrl("/")// 로그아웃 성공시 메인 화면으로 이동한다.
                .and()
                .oauth2Login() //oAuth 로그인 기능에대한 여러 설정 진입점
                .userInfoEndpoint() // 사용자 정보를 가져올때 설정 담당
                .userService(customUserTypesOAuth2UserService);
    }
}
