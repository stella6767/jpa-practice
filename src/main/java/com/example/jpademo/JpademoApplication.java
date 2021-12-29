package com.example.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }

}


/**
 * 스프링 컨테이너 + JPA의 기본전략
 * 스프링 컨테이너는 트랜잭션 범위의 영속성 컨텍스트 전략을 기본으로 사용한다.
 * 트랜잭션의 범위와 영속성 컨텍스트의 생존범위가 같다는 뜻이다.
 * 트랜잭션이 시작되면, 영속성 컨텍스트를 생성하고, 트랜잭션이 끝나면, 영속성 컨텍스트를 종료한다.
 * 같은 트랜잭션 안에는 항상 같은 영속성 컨텍스트에 접근한다.
 * 주의할 점은 하나의 트랜잭션 안에 쿼리를 수행해서 결과를 바꿨다 하더라도 같은 트랜잭션 안에 수정된
 * 결과를 조회해도 변경된 값이 조회되지는 않음.
 * 트랜잭션이 달린 메서를 호출하면, 스프링의 트랜잭션 aop 가 먼저 동작, aop는 대상 메서드를 호출하기 전에
 * 트랜잭션을 시작하고, 대상 메서드가 종료되면, 트랜잭션을 커밋하면서 종료한다. 이때 트랜잭션을 커밋하면
 * JPA는 영속성 컨텍스트를 플러시해서 변경 내용을 DB에 반영한 후, DB 트랜잭션을 커밋한다.
 * 만약 예외가 발생하면 트랜잭션을 롤백하고 종료하는데, 이 때는 플러시를 호출하지 않는다.
 *
 * 트랜잭션이 다르면 다른 영속성 컨텍스트를 사용하기 때문에, 여러 스레드에서 동시에 요청이 와서
 * 같은 엔티티매니저를 사용해도, 트랜잭션에 따라 접근하는 영속성 컨텍스트가 다르다. 따라서 멀티스레드에 안전
 * 개발자는 편하게 동시성 같은 문제 신경쓰지 않고, 싱글쓰레드 작업하는 것처럼 작업하면 된다.
 */



