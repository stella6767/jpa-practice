package com.example.jpademo.config;


import com.example.jpademo.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitMember {

    private final InitMemberService initMemberService;

    @PostConstruct //PostConstruct 와 Transactional을 같이 넣을 수 없다.
    public void init(){
        initMemberService.init();
    }


    @Component
    static class InitMemberService{
        @PersistenceContext
        private EntityManager em;

        /**
         * 위는 컨테이너가 관리하는 엔티티 매니저를 주입받을 수 있고,
         * 엔티티 매니저 팩토리를 주입받으려면 다음처럼 @PersistenceUnit 어노테이션을 사용해야 한다.
         *  // @PersistenceUnit
         *  //private EntityManager em;
         */


        @Transactional
        public void init(){

            Random random = new Random();

            for (int i=0; i<100; i++){
                em.persist(new Member("홍길동", random.nextInt()+100, false));
            }

        }


    }
}
