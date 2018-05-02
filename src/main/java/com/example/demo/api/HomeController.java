package com.example.demo.api;

import com.example.demo.api.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 10:08
 */
@RequestMapping("/api/home")
@RestController
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> home(){
        return new ResponseEntity<ResponseDto>(
                    ResponseDto
                            .builder()
                            .msg("OK")
                            .httpStatus(HttpStatus.OK)
                            .data("home controller")
                            .build(),
                    HttpStatus.OK
                );
    }
}
