package com.cos.blog.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String title;
	@Lob
	private String content;
	private int count;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // FK가 아님. DB에 컬럼 만들지 않음.
	@JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private List<Reply> replys;
	@CreationTimestamp
	private LocalDateTime createDate;
}
