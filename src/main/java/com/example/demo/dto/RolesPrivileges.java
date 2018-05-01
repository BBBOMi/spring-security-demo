package com.example.demo.dto;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 1:41
 */
public class RolesPrivileges {
    private String roleName;
    private String privilegeName;

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName(){
        return this.roleName;
    }

    public void setPrivilegeName(String privilegeName){
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeName(){
        return this.privilegeName;
    }

    @Override
    public String toString(){
        return String.format("RolesPrivileges( roleName = %s, privilegeName = %s)",this.roleName,this.privilegeName);
    }
}
