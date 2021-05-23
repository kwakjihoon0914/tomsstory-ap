package com.tomsstory.app.blog.repository;

import com.tomsstory.app.blog.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
