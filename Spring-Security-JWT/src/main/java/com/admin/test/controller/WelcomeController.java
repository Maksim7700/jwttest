package com.admin.test.controller;

import com.admin.test.entity.User;
import com.admin.test.service.CustomUserDetailService;
import com.admin.test.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.admin.test.entity.AuthRequest;
import com.admin.test.util.JwtUtil;

import java.util.List;

@RestController
public class WelcomeController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@GetMapping("/")
	public List<User> welcome() {
		return customUserDetailService.findAllUser();
	}

	@GetMapping("/{age}")
	public List<User> ageUsers(@PathVariable Integer age) {
		return customUserDetailService.findUserAge(age);
	}

	@GetMapping("/color/{id}")
	public List userColor(@PathVariable Integer id) {
		return customUserDetailService.findU(id);
	}

	@GetMapping("/three")
	public List getUserThree() {
		return customUserDetailService.findThreeOrMore();
	}

	@GetMapping("/articles")
	public List getArticles() {
		return customUserDetailService.findAllArticle();
	}

	@PostMapping(value = "/saveuser")
	public User saveUser(@RequestBody User user) {
		customUserDetailService.saveUser(user);
		return user;
	}

	@PostMapping(value = "/savearticle")
	public Article saveArticle(@RequestBody Article article) {
		customUserDetailService.saveArticle(article);
		return article;
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(), authrequest.getPassword()));
		}
		catch (Exception e) {
			throw new Exception("Invalid username and password");
		}
		
		return jwtUtil.generateToken(authrequest.getUserName());
	}
}
