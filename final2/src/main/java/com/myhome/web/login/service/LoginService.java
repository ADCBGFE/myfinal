package com.myhome.web.login.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.web.login.model.LoginRequest;
import com.myhome.web.login.model.MemberDAO;
import com.myhome.web.login.model.MemberDTO;

@Service
public class LoginService {
	@Autowired
	private MemberDAO memberDao;

	public MemberDTO login(LoginRequest loginRequest) {
		System.out.println("id : " + loginRequest.getMbId());
		System.out.println("pwd : " + loginRequest.getMbPw());
		// 1. id, pwd 확인
		MemberDTO memberDto = memberDao.selectUser(loginRequest.getMbId());
		
		if (isExistsUser(memberDto, loginRequest.getMbPw())) {
			return memberDto;
		}
		// 오류나면 어떤 요청이있는데 오류가 났는지
		throw new IllegalArgumentException("유저없음!" + loginRequest);
	}

	private boolean isExistsUser(MemberDTO memberDto, String mbPw) {
		if (memberDto == null) {
			return false; // 유저가 null이면 없는거니까
		}

		if (!memberDto.getMbPw().equals(mbPw)) {
			return false;
		}

		return true;
	}
}
