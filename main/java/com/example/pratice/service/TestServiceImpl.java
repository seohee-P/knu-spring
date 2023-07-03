package com.example.pratice.service;

import com.example.pratice.domain.member.Member;
import com.example.pratice.domain.test.MemoryTestRepository;
import com.example.pratice.domain.test.TestRepository;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class TestServiceImpl implements TestService{

    // 레포지토리와 연결하기(의존성 주입) final은 꼭 어디선가 초기화가 되어야 한다.
    // 그래서 뉴를 추가 하지만 이건 객체지향적인 것이 아니다.
    //private final TestRepository testRepository = new MemoryTestRepository();


    private final TestRepository testRepository;

    // 이것도 객체지향적인 것이 아니다. 파라미터로 구현체를 받아오면 안된다.
//    public TestServiceImpl(MemoryTestRepository memoryTestRepository){
//        this.testRepository = memoryTestRepository;
//    }

    public TestServiceImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    // Create
//    public Long joinTest(Map<String, String> map) {
//        return testRepository.save(map);
//    }@Override
    @Override
    public Long joinTest(Member member) {
        return testRepository.save(member);
    }

    // Read
//    @Override
//    public Map<String, String> findTestById(Long id) {
//        return testRepository.findByID(id);
//    }
    @Override
    public Member findTestById(Long id) {
        return testRepository.findById(id);
    }


    // update
    @Override
    public Member modifyTestById(Long id, Member member) {
        return testRepository.modifyById(id, member);
    }

    // delete
    @Override
    public Long removeTestById(Long id) {
        return testRepository.removeById(id);
    }
}
