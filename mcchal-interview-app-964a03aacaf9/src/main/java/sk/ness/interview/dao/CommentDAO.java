package sk.ness.interview.dao;

import java.util.List;


import sk.ness.interview.domain.Comment;

public interface CommentDAO {

	  /** Returns all available {@link Comments}s */
	  List<Comment> findAll();
	  
	  /** Persists {@link Comment} into the DB */
	  void persist(Comment comment);
}
