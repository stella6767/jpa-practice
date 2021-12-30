package com.example.jpademo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EnableJpaAuditing //엔티티의 변경 시점에 언제, 누가 변경했는지에 대한 정보를 기록하는 기능
@Configuration
public class JPAConfig {

    /**
     * entity manager는 @Autowired가 아니고 특별하게 @PersistenceContext라는 어노테이션으로 주입을 해줄 수 있다.
     * 근데 최신 스프링부트에서는 @Autowired로도 할 수 있다고 한다.
     *
     */

    @PersistenceContext
    private EntityManager entityManager;

    @Bean //동시성 문제 신경 안 써도 됨. 트랜잭션 붙여주면 트랜잭션 단위로 다 다른 것으로 할당해서 바인딩해줌
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
