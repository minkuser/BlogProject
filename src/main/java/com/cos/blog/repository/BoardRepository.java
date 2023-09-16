package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
}

//User findByUsernameAndPassword(String username, String password);
//@Query(value = "select * from user where username = ?1 and password =?2", nativeQuery = true)
//User login(String username, String password);