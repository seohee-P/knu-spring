package com.example.pratice.web;

import com.example.pratice.domain.member.Member;
import com.example.pratice.service.TestService;
import com.example.pratice.service.TestServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //crud
@RequestMapping("/api/latest") //괄호 안에 있는 건 우리 마음대로 정해도 된다. 클래시 단위 mapping
public class TestController {

    private final TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    //Create
    @PostMapping("/join")
    //http://localhost:8080/api/latest/join
    public ResponseEntity<String> create(@RequestBody Member member) {
        //map에 담겨오는 파라미터는 val1, val2
        // 잘 담겨 왔는지 확인
        testService.joinTest(member);
        System.out.print("id = " + member.getId());
        System.out.print("name = " + member.getName());
        System.out.println("grade = " + member.getGrade());

        return ResponseEntity.ok("CREATED");
    }

    //Read - 단건 조회
    @GetMapping("/test/{id}")
    //http://localhost:8080/api/latest/test/1
    //http://localhost:8080/api/latest/test/2
    public ResponseEntity<String> read(@PathVariable Long id){
        Member readMember = testService.findTestById(id);
        System.out.println("id = " + id);
        String s = "id:"+readMember.getId() + ", name:"+readMember.getName() + ", grade:"+readMember.getGrade();
        return ResponseEntity.ok(s);
    }

    //Update - 어떤 회원 수정
    @PutMapping("/test/{id}")
    //http://localhost:8080/api/latest/test/1
    //http://localhost:8080/api/latest/test/2
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Member member){
        testService.modifyTestById(id, member);
        System.out.println("id = " + id);
        return ResponseEntity.ok("UPDATED");
    }

    //Delete
    @DeleteMapping("/test/{id}")
    //http://localhost:8080/api/latest/test/1
    //http://localhost:8080/api/latest/test/2
    public ResponseEntity<String> delete(@PathVariable Long id){
        System.out.println("id = " + id);
        testService.removeTestById(id);
        return ResponseEntity.ok("DELETED");
    }
}
