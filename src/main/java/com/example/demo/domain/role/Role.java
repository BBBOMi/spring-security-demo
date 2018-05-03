package com.example.demo.domain.role;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 12:26
 */
@Data
public class Role {
    private Long id;
    private String name;

}
