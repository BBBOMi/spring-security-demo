package com.example.demo.domain.member;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:26
 */
public class Member {
    private Long id;
    private String name;
    private String password;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString(){
        return String.format("Member( id = %d, name = %s)",this.id,this.name);
    }
}
