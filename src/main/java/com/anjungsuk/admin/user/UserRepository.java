package com.anjungsuk.admin.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String Email);//소셜 로그인 반환되는 값 중 email통해 생성된 사용자인지 처음 가입하는 사용자인지 판단하는 메소드
}
