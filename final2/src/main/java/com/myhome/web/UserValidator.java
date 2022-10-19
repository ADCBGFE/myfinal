package com.myhome.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myhome.web.login.model.MemberDTO;
import com.myhome.web.login.model.registerDTO;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
//		return UserDTO2.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
		return MemberDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { 
		System.out.println("UserValidator.validate() is called");

//		UserDTO2 userDto2 = (UserDTO2)target;
		MemberDTO memberDto = (MemberDTO)target;
		
//		String id = userDto2.getId();
		String id = memberDto.getMbId();
		
//		if(id==null || "".equals(id.trim())) {
//			errors.rejectValue("id", "required");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mbId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mbPw", "required");
		
		if(id==null || id.length() <  3 || id.length() > 22) {
			errors.rejectValue("mbId", "invalidLength", new String[]{"3","22"}, null);
		}
	}
}