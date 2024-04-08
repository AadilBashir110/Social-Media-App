package com.adil.service;

import com.adil.exceptions.CommentException;
import com.adil.exceptions.PostException;
import com.adil.exceptions.UserException;
import com.adil.models.Comment;

public interface CommentService {

	public Comment createComment(Comment comment,Integer postId,Integer userId) throws CommentException, UserException, PostException;
	
	public Comment findCommentById(Integer commentId) throws CommentException;
	
	public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException;
}
