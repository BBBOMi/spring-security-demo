package com.example.demo.advice;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:02
 */
public class JwtException extends RuntimeException{
    public JwtException(String msg){
        super(msg);
    }
}
