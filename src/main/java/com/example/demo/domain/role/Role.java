package com.example.demo.domain.role;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:26
 */
public class Role {
    private Long id;
    private String name;

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

    public boolean predicate(String name){
        return this.name.equals(name);
    }
}
