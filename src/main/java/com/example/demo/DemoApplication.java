package com.example.demo;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MemberMapper;
import com.example.demo.domain.resource.Resource;
import com.example.demo.domain.resource.ResourceMapper;
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

	//	@Bean//초기 데이터 적제
	//	CommandLineRunner bootstrapTestAccount(MemberMapper memberMapper, RoleMapper roleMapper, ResourceMapper resourceMapper, PasswordEncoder passwordEncoder) {
	//		return args -> {
	//			Member adminMember = new Member();
	//			adminMember.setName("admin");
	//			adminMember.setPassword(passwordEncoder.encode("admin"));
	//
	//			memberMapper.save(adminMember);
	//
	//			Member userMember = new Member();
	//			userMember.setName("user");
	//			userMember.setPassword("user");
	//
	//			memberMapper.save(userMember);
	//
	//			Role adminRole = new Role();
	//			adminRole.setName("ROLE_ADMIN");
	//
	//			roleMapper.save(adminRole);
	//
	//			Role userRole = new Role();
	//			userRole.setName("ROLE_USER");
	//
	//			roleMapper.save(userRole);
	//
	//			Resource user = new Resource();
	//			user.setName("/user");
	//			resourceMapper.save(user);
	//
	//			Resource admin = new Resource();
	//			admin.setName("/admin");
	//			resourceMapper.save(admin);
	//
	//			Resource home = new Resource();
	//			home.setName("/home");
	//			resourceMapper.save(home);
	//
	//			roleMapper.rolesResourcesSave(adminRole.getId(),admin.getId());
	//			roleMapper.rolesResourcesSave(userRole.getId(),user.getId());
	//			roleMapper.rolesResourcesSave(userRole.getId(),home.getId());
	//			roleMapper.rolesResourcesSave(adminRole.getId(),home.getId());
	//
	//			memberMapper.membersRolesSave(adminMember.getId(),adminRole.getId());
	//			memberMapper.membersRolesSave(userMember.getId(),userRole.getId());
	//		};
	//	}
}
