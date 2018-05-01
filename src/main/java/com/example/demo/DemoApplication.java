package com.example.demo;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberMapper;
import com.example.demo.domain.privilege.Privilege;
import com.example.demo.domain.privilege.PrivilegeMapper;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.role.RoleMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean //초기 데이터 적제
//	CommandLineRunner bootstrapTestAccount(MemberMapper memberMapper, RoleMapper roleMapper, PrivilegeMapper privilegeMapper, PasswordEncoder passwordEncoder) {
//		return args -> {
//			Member member = new Member();
//			member.setName("iljun");
//			member.setPassword(passwordEncoder.encode("1234"));
//
//			memberMapper.save(member);
//
//			Role role = new Role();
//			role.setName("USER");
//
//			roleMapper.save(role);
//
//			Privilege privilege = new Privilege();
//			privilege.setName("ALL");
//
//			privilegeMapper.save(privilege);
//
//			memberMapper.membersRolesSave(member.getId(),role.getId());
//			roleMapper.rolesPrivilegesSave(role.getId(),privilege.getId());
//		};
//	}
}
