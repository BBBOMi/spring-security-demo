package com.example.demo.api.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:04
 */
@Data
@Builder
public class ResponseDto {
    private String msg;
    private HttpStatus httpStatus;
    private Object data;
}
