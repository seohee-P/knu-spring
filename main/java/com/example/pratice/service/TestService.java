package com.example.pratice.service;

import com.example.pratice.domain.member.Member;

import java.util.Map;

public interface TestService {


    // service에서는 왜 에노테이션을 안 달까
    // 테스트 생성 - C
    //Long joinTest(Map<String,String> map);
    Long joinTest(Member member);

    // 테스트 단건 조회 - R
    //Map<String, String> findTestById(Long id);
    Member findTestById(Long id);

    // 테스트 수정 - U
    Member modifyTestById(Long id,Member member);

    // 테스트 삭제 - D
    Long removeTestById(Long id);
}
