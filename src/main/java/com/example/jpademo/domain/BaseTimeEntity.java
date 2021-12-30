package com.example.jpademo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //테이블과 매핑되지 않는다. JPA has no direct support for interfaces or variable relationships. 인터페이스는 안됨..
@EntityListeners(AuditingEntityListener.class) //Auditing 기능포함
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime modifiyTime;

    /**
     * 부모로부터 물려받은 매핑 정보를 재정의하려면, @AttributeOverrides나 @AttributeOverride를 사용
     * 연관관계를 재정의하려면 @AssociationOberrides를 사용
     */

    /**
     * 식별관계 : 부모 테이블의 기본키를 내려받아서 자식 테이블의 기본 키 + 외래키로 사용
     * 비식별관계: 부모 테이블의 기본 키를 받아서 자식 테이블의 외래 키로만 사용.(추천)
     */

}
