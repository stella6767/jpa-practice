package com.example.jpademo.domain.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository  //QueryDsl 용도
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    QMember member = QMember.member;

    @Override
    public List<Member> findMemberByNameIsNull() {

        return jpaQueryFactory
                .selectFrom(member)
                .where(member.name.isNull())
                .fetch();
    }
}
