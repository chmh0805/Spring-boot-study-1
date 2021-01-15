package com.cos.study.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.study.domain.CommonDto;
import com.cos.study.domain.JoinReqDto;
import com.cos.study.domain.UpdateReqDto;
import com.cos.study.domain.User;
import com.cos.study.domain.UserRepository;


@RestController
public class UserController {

	private UserRepository userRepository;
	
	// DI(Dependency Injection) : 의존성 주입
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// http://localhost:8080/user
	@GetMapping("/user")
	public CommonDto<List<User>> findAll() {
		System.out.println("findAll()");
		// MessageConverter 동작 (JavaObject -> Json String)
		return new CommonDto<>(HttpStatus.OK.value(), userRepository.findAll());
	}

	// http://localhost:8080/user/3
	@GetMapping("/user/{id}") // 주소에 적힌 {id}부분을 매개변수로 받을 수 있다.
	public CommonDto<User> findById(@PathVariable int id) { // 변수명은 똑같이 해줘야 인식된다.
		System.out.println("findById("+ id +")");
		return new CommonDto<>(HttpStatus.OK.value(), userRepository.findById(id));
	}
	
	// http://localhost:8080/user
	@PostMapping("/user")
	// x-www-form-urlencoded를 파싱해서 매개변수에 있는 param값에 넣어준다.(request.getParameter())
	// text/plain => @RequestBody 어노테이션을 사용하면 받을 수 있다.
	// application/json => @RequestBody 어노테이션 + 오브젝트로 받기
	public CommonDto<?> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {
		
		System.out.println("save()");
		System.out.println("user : " + dto);
		userRepository.save(dto);
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
//		System.out.println("phone : " + phone);
//		System.out.println("data : " + data);
//		System.out.println("User : " + user);
		
		return new CommonDto<>(HttpStatus.CREATED.value(), "ok");
	}
	
	// http://localhost:8080/user/3
	@DeleteMapping("/user/{id}")
	public CommonDto<String> delete(@PathVariable int id) {
		System.out.println("delete()");
		userRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value());
	}
	
	// http://localhost:8080/user/3
	@PutMapping("/user/{id}")
	public CommonDto<?> update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		
		System.out.println("update()");
		userRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value());
	}
}
