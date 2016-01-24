package sk.ness.interview.service;

import java.util.List;



import sk.ness.interview.domain.Comment;

/**
 * Service should be used as a gateway to {@link Comment} world and handle all comment related manipulation.
 *
 * @author ivana.kralikova
 *
 */
public interface CommentService {
	/** Returns all available {@link Comment}s */
	List<Comment> findAll();

	/** Creates new {@link Comment} */
	void createComment(Comment comment);

	/** Creates new {@link Comment}s by ingesting all comments from json */
	void ingestComments(String jsonComments);

	

}
