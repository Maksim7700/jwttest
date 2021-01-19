package com.admin.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.test.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);
	List<User> findAll();

	@Query(value = "select * from USER where age > ?1",
	nativeQuery = true)
	List<User> findUserAge(int age);

	@Query(value = "select user.username, article.color from article left join user where user.id = article.u_id and article.color = ?1", nativeQuery = true)
	List findAllByColor(Integer id);

	@Query(value = "select article.u_id ,count(article.id)>3 from article group by article.u_id", nativeQuery = true)
	List findMoreThanThree();

}
