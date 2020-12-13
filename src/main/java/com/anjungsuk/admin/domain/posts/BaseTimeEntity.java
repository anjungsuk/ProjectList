package com.anjungsuk.admin.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA entity 클래스들이 BaseTimeEntity를 상속 할경우 필드들도 칼럼으로 인식하게 하는 어노테이션
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능 삽입
public class BaseTimeEntity  { //모든entity의 상위클래스가 되어 createdDate, modifiedDate를 자동 관리한다
    @CreatedDate // Entity가 생성되어 저장 될때 자동 저장
    private LocalDateTime createdDate;
    @LastModifiedDate // 조회한 Entity의 값을 변경 할때 시간 자동 저장
    private LocalDateTime modifiedDate;
}
