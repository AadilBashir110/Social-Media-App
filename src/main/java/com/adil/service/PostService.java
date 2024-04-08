package com.adil.service;

import java.util.List;

import com.adil.exceptions.PostException;
import com.adil.exceptions.UserException;
import com.adil.models.Post;

public interface PostService {

	Post createNewPost(Post post,Integer userId) throws PostException, UserException;
	
	String deletePost(Integer postId,Integer userId) throws PostException, UserException;
	
	List<Post> findPostByUserId(Integer userId);
	
	Post findPostById(Integer postId) throws PostException;
	
	List<Post> findAllPost();
	
	Post savedPost(Integer postId, Integer userId) throws PostException, UserException;
	
	Post likePost(Integer postId, Integer userId) throws PostException, UserException;
}
