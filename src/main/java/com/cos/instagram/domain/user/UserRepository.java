package com.cos.instagram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.instagram.web.dto.JoinReqDto;

// JpaRepository가 extends가 되면 @Repository가 필요없음 ioc 자동으로 됨
public interface UserRepository extends JpaRepository<User, Integer>{

	
	
	
}
