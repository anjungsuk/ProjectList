package com.anjungsuk.admin.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor// 파라미터가 없는 기본 생성자를 생성하는 어노테이션
@Entity// 엔티티 클래스 User 클래스를 테이블과 매핑시킨다.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // name속성을 컬럼 매핑 하지만 null값을 허용 하지 않는다.
    private String name;

    @Column(nullable = false) // email속성을 매핑 하지만 null값을 허용 하지 않는다.
    private String email;

    @Column
    private String picture; //picture 속성을 문자열로 매핑한다.

    @Enumerated(EnumType.STRING) // Role role DB내에 문자열값을 저장한다.
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }
}
