package com.example.pratice.domain.test;

import com.example.pratice.domain.member.Member;

import java.util.Map;

public interface TestRepository {

    // C
    // Long save(Map<String, String> map);
    Long save(Member member);

    // R
    // Map<String, String> findByID(Long id);
    Member findById(Long id);

    // U
    Member modifyById(Long id, Member member);

    // D
    Long removeById(Long id);
}
