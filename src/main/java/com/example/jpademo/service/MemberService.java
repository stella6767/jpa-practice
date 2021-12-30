package com.example.jpademo.service;


import com.example.jpademo.domain.member.Member;
import com.example.jpademo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(){

        //validateDuplicateMember();

        return null;
    }



    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByUsername(member.getUsername());
        if(!findMembers.isEmpty()){
            throw new IllegalArgumentException("이미 존재하는 회원입니다!!");
        }
    }




}
