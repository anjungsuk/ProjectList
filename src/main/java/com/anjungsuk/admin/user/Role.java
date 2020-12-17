package com.anjungsuk.admin.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GEUST", "손님"), // DB내 GUEST 키값 내용 생성
    USER("ROLE_USER", "일반사용자"); // DB내 USER 키값 내용 생성

    private final String key; // final 선언으로 DB내 문자열 key 생성
    private final String title; // final 선언으로 DB내 문자열 title 생성
}
