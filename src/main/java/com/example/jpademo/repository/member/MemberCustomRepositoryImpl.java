package com.example.jpademo.repository.member;

import com.example.jpademo.domain.member.Member;
import com.example.jpademo.dto.MemberSearchCondition;
import com.example.jpademo.dto.MemberTeamDto;
import com.example.jpademo.dto.QMemberTeamDto;
import com.example.jpademo.repository.member.MemberCustomRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpademo.domain.member.QMember.*;
import static org.springframework.util.StringUtils.hasText;

//Impl 네이밍 규칙
@RequiredArgsConstructor
@Repository  //QueryDsl 용도
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory queryFactory;



}
