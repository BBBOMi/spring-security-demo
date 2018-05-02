package com.example.demo.advice;

import com.example.demo.api.response.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:03
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> defaultExceptionHandler(Exception e){
        log.error(e.getMessage());

        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(e.getMessage())
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ResponseDto> loginExceptionHandler(LoginException e){
        log.error(e.getMessage());

        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(e.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ResponseDto> jwtExceptionHandler(JwtException e){
        log.error(e.getMessage());

        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(e.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDto> badRequestExceptionHandler(BadRequestException e){
        log.error(e.getMessage());

        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(e.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
