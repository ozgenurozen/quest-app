package com.project.questapp.requests;

import lombok.Data;

@Data
public class LikesCreateRequest {
	
	Long id;
	Long userId;
	Long postId;
	
}