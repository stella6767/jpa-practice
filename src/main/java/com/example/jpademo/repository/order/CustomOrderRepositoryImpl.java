package com.example.jpademo.repository.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CustomOrderRepositoryImpl implements CustomOrderRepository {

    private final JPAQueryFactory queryFactory;







}
