package com.myhome.web.login.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.web.UserValidator;
import com.myhome.web.login.model.MemberDAO;
import com.myhome.web.login.model.MemberDTO;
import com.myhome.web.login.service.RegisterService;

@RestController							
@RequestMapping("/register")	
public class RegisterController {	
	
	@Autowired
	RegisterService registerService;

	// 회원가입	http://localhost:8080/web/register/save
	@PostMapping("/save")
	public void save(@RequestBody @Valid MemberDTO memberDto) {
		registerService.save(memberDto);
 	}
		
}
