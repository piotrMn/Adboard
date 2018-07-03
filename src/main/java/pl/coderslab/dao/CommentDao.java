package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Comment;

public interface CommentDao {
	
	public List<Comment> getCommentsByAdId(long id);
	
	public void saveComment(Comment comment);

}
