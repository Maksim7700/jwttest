package com.admin.test.service;

import java.util.ArrayList;
import java.util.List;

import com.admin.test.entity.User;
import com.admin.test.repository.UserRepository;
import com.admin.test.entity.Article;
import com.admin.test.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService  implements UserDetailsService{

	@Autowired
	private UserRepository repository;

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = repository.findByUserName(username);
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
		
	}

	public List<User> findAllUser() {
		List<User> list;
		list = repository.findAll();
		return list;
	}

	public List<User> findUserAge(int age) {
		List<User> list;
		list = repository.findUserAge(age);
		return list;
	}


	public List findU(Integer id) {
		List list;
		list = repository.findAllByColor(id);
		return list;
	}

	public List findThreeOrMore() {
		List list;
		list = repository.findMoreThanThree();
		return list;
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	public List findAllArticle() {
		return articleRepository.findAll();
	}

}
