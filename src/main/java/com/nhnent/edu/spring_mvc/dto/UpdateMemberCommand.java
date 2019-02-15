package com.nhnent.edu.spring_mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// TODO : #2 Member 수정시 사용될 command 객체.
// TODO : #2 a command which is used when a member is updated.
public class UpdateMemberCommand {
    @NotEmpty
    private String name;

    @NotNull
    @Min(8)
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
