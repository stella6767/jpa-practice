package com.example.jpademo.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberCustomRepository {


    List<Member> findMemberByNameIsNull();

}
