package com.adil.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.exceptions.CommentException;
import com.adil.exceptions.PostException;
import com.adil.exceptions.UserException;
import com.adil.models.Comment;
import com.adil.models.Post;
import com.adil.models.User;
import com.adil.repository.CommentRepository;
import com.adil.repository.PostRepository;

@Service
public class CommentServiceImplementation implements CommentService{

	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentException, UserException, PostException {
		
		User user = userService.findUserById(userId);
		
		Post post = postService.findPostById(postId);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		
		Comment savedComment = commentRepository.save(comment);
		post.getComments().add(savedComment);
		postRepository.save(post);
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer commentId) throws CommentException {
		
		Optional<Comment> opt = commentRepository.findById(commentId);
		
		if(opt.isEmpty()) {
			throw new CommentException("comment not exist");
		}
		
		return opt.get();
	}

	@Override
	public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException {
		
	    Comment comment	= findCommentById(commentId);
		User user = userService.findUserById(userId);
		
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}
		else comment.getLiked().remove(user);
		
		return commentRepository.save(comment);
	}

}
