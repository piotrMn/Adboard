package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.CommentDTO;

public interface CommentDao {
	
	public List<Comment> getCommentsByAdId(long id);
	
	public void saveComment(CommentDTO commentDTO);

}
