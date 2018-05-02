package com.example.demo.advice;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 2
 * Time: 오전 12:23
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg){
        super(msg);
    }
}
