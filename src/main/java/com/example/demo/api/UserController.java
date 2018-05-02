package com.example.demo.api;

import com.example.demo.api.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:35
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> user(){

        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .httpStatus(HttpStatus.OK)
                        .msg("User 권한 접근")
                        .data("User 권한입니다.")
                        .build(),
                HttpStatus.OK
        );
    }
}
