package com.project.questapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {
	Long id;
	Long postId;
	Long userId;
	@Lob
	@Column(columnDefinition="text")
	String text;
	
}
