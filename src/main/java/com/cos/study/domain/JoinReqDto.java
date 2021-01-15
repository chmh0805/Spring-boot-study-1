package com.cos.study.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class JoinReqDto {
	
	@NotBlank(message = "id를 입력하세요.")
	@Size(max = 20, message = "id값을 20자 이내로 설정하세요.")
	private String username;
	
	@NotBlank(message = "비밀번호를 입력하세요.")
	@Size(max = 10, message = "비밀번호값을 10자 이내로 설정하세요.")
	private String password;
	
	private String phone;

}
