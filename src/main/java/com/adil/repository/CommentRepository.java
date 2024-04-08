package com.adil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adil.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
