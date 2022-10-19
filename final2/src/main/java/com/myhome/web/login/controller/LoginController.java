package com.myhome.web.login.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.web.login.model.LoginRequest;
import com.myhome.web.login.model.MemberDAO;
import com.myhome.web.login.model.MemberDTO;
import com.myhome.web.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	@ResponseBody // postman에서 post로 보낼때 body로 담아보낼때 씀
	public MemberDTO Login(@RequestBody @Valid LoginRequest loginRequest) {// 바디가 {} 로 하나로 받으니까 객체별로 보낼수 없으니 하나로 묶어논 클래스 {
		return loginService.login(loginRequest);
	}

}
