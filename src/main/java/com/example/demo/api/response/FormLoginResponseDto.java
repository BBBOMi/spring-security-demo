package com.example.demo.api.response;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 3:24
 */
@Data
public class FormLoginResponseDto {
    private String token;

    public FormLoginResponseDto(String token){
        this.token = token;
    }
}
