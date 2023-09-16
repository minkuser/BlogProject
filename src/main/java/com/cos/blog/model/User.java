package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;	
	@Column(unique = true, nullable = false, length = 100)
	private String username;
	@Column(length = 100)
	private String password;
	@Enumerated(EnumType.STRING)
	private RoleType role;	
	@Column(nullable = false, length = 50)
	private String email;
	
	private String oauth;
	
	@CreationTimestamp
	private Timestamp createDate; 
}
