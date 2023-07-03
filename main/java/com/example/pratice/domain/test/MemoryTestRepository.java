package com.example.pratice.domain.test;

import com.example.pratice.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryTestRepository implements TestRepository{

//    private final List<Map <String,String>> collectors = new ArrayList<>();
    private final List<Member> collectors = new ArrayList<>();

    @Override
    public Long save(Member member) {
        collectors.add(member);
        return member.getId();
    }

    @Override
    public Member findById(Long id) {

        return collectors.stream().filter(member -> 1L == member.getId())
                .findAny()
                .orElse(null);
    }

    @Override
    public Member modifyById(Long id, Member member) {
        Member mMember = findById(id);
        mMember.setName(member.getName());
        mMember.setGrade(member.getGrade());

        return mMember;
    }

    @Override
    public Long removeById(Long id) {
        collectors.stream().filter(member -> 1L == member.getId())
                .collect(Collectors.toList())
                .forEach(li -> {collectors.remove(li); });
        return id;
    }


//    // Create
//    @Override
//    public Long save(Map<String, String> map) {
//        collectors.add(map);
//        // val1 - id
//        // val2 - name
//        return map.get("val1");
//        // 에러가 나는 원인은 map은 String으로 선언되어 있는데 return 타입은 Long
//        //이므로 타입이 맞지 않아서 에러가 난다.
//        // String val1 "1" 값을 Long으로 변환하여 넘겨준다. **mission**
//    }
//
//    // Read
//    @Override
//    public Map<String, String> findByID(Long id) {
//        //1 -id ----> list index 0
//        //2 -id ----> list index 1
//        //3 -id ----> list index 2
//        // Long id -1
//
//        collectors.get(id.intValue()-1);
//        //Map 과 list는 서로 호환이 된다.
//        return collectors.get(id.intValue()-1);
//    }
}
