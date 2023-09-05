package com.project.questapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.project.questapp.entities.Likes;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.LikesRepository;
import com.project.questapp.requests.LikesCreateRequest;
import com.project.questapp.responses.LikesResponse;

@Service
public class LikesService {

	private LikesRepository likesRepository;
	private UserService userService;
	private PostService postService;

	public LikesService(LikesRepository likesRepository, UserService userService, 
			PostService postService) {
		this.likesRepository = likesRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<LikesResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Likes> list;
		if(userId.isPresent() && postId.isPresent()) {
			list = likesRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			list = likesRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			list = likesRepository.findByPostId(postId.get());
		}else
			list = likesRepository.findAll();
		return list.stream().map(likes -> new LikesResponse(likes)).collect(Collectors.toList());
	}

	public Likes getOneLikeById(Long likeId) {
		return likesRepository.findById(likeId).orElse(null);
	}

	public Likes createOneLike(LikesCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Likes likesToSave = new Likes();
			likesToSave.setId(request.getId());
			likesToSave.setPost(post);
			likesToSave.setUser(user);
			return likesRepository.save(likesToSave);
		}else		
			return null;
	}

	public void deleteOneLikeById(Long likesId) {
		likesRepository.deleteById(likesId);
	}
}
