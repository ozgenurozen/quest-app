package com.project.questapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.Likes;

public interface LikesRepository extends JpaRepository<Likes,Long>{

	List<Likes> findByPostId(Long long1);

	List<Likes> findByUserId(Long long1);

	List<Likes> findByUserIdAndPostId(Long long1, Long long2);

}
