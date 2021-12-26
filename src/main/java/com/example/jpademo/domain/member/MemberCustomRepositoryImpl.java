package com.example.jpademo.domain.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpademo.domain.member.QMember.*;

@RequiredArgsConstructor
@Repository  //QueryDsl 용도
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;



    @Override
    public List<Member> findMemberByNameIsNull() {

        return jpaQueryFactory
                .selectFrom(member)
                .where(member.username.isNull())
                .fetch();
    }
}
