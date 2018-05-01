package com.example.demo.advice;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:57
 */
public class LoginException extends RuntimeException{
    public LoginException(String msg){
        super(msg);
    }
}
