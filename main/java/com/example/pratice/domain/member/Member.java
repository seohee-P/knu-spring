package com.example.pratice.domain.member;

public class Member {
    private Long id;
    private String name;
    private String grade;

    public Member(Long id,String name, String grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getGrade(){
        return grade;
    }

}
