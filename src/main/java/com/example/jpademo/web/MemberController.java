package com.example.jpademo.web;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

//    private final MemberJpaRepository memberJpaRepository;
//    private final MemberRepository memberRepository;
//
//
//
//    @GetMapping("/v1/members")
//    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition){
//
//        logger.info("?");
//        return memberJpaRepository.search(condition);
//    }
//
//
//    @GetMapping("/v2/members")
//    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition, Pageable page){
//
//        return memberRepository.searchPageSimple(condition, page);
//    }
//
//    @GetMapping("/v3/members")
//    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition, Pageable page){
//
//        return memberRepository.searchPageComplex(condition, page);
//    }
//

}
