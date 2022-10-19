package com.myhome.web.login.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.myhome.web.login.model.MemberDAO;
import com.myhome.web.login.model.MemberDTO;

@Service
public class RegisterService {
	@Autowired
	private MemberDAO memberDao;

	// 회원가입
	public void save(@RequestBody @Valid MemberDTO memberDto){
		System.out.println("memberDto=" + memberDto);

		memberDao.insertUser(memberDto);

	}

}
