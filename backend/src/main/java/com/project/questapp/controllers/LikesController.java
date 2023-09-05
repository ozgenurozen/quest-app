package com.project.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.Likes;
import com.project.questapp.requests.LikesCreateRequest;
import com.project.questapp.responses.LikesResponse;
import com.project.questapp.services.LikesService;

@RestController
@RequestMapping("/likes")
public class LikesController {

	private LikesService likesService;
	

	public LikesController(LikesService likeService) {
		this.likesService = likeService;
	}
	
	@GetMapping
	public List<LikesResponse> getAllLikes(@RequestParam Optional<Long> userId, 
			@RequestParam Optional<Long> postId) {
		return likesService.getAllLikesWithParam(userId, postId);
	}
	
	@PostMapping
	public Likes createOneLike(@RequestBody LikesCreateRequest request) {
		return likesService.createOneLike(request);
	}
	
	@GetMapping("/{likeId}")
	public Likes getOneLike(@PathVariable Long likesId) {
		return likesService.getOneLikeById(likesId);
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable Long likesId) {
		likesService.deleteOneLikeById(likesId);
	}
}
