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
 * Time: 오후 5:34
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @RequestMapping(value ="" , method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> admin(){

        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg("ADMIN 권한 접근")
                        .httpStatus(HttpStatus.OK)
                        .data("ADMIN 권한입니다.")
                        .build(),
                HttpStatus.OK
        );
    }
}

