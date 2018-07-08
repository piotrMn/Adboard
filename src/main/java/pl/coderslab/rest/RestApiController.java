package pl.coderslab.rest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.CommentDTO;
import pl.coderslab.entity.User;
import pl.coderslab.service.GenericService;
import pl.coderslab.service.SpecificService;

@RestController
@RequestMapping("/rest")
public class RestApiController {
	
	@Autowired
	SpecificService specificService;
	
	@Autowired
	GenericService<User> userService;
	
	@Autowired
	GenericService<Ad> adService;
	
	@GetMapping("/comments/{adId}")
	public List<Comment> getCommentsForAd(@PathVariable("adId") long id) {
		return specificService.getCommentsByAdId(id);
	}
	
	@RequestMapping(value = "/comments", method = {RequestMethod.POST}, 
	consumes = {"application/json"})
	public CommentDTO addComment(@RequestBody CommentDTO commentDTO) {
		specificService.saveComment(commentDTO);
		return commentDTO;
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable("userId") long userId) {
		return userService.getEntityById(User.class, userId);
	}
	
	@GetMapping("/ads/{adId}")
	public Ad getAdById(@PathVariable("adId") long adId) {
		return adService.getEntityById(Ad.class, adId);
	}
	
	@GetMapping("/now")
	public Timestamp getCurrentTimestamp() {
		return Timestamp.valueOf(LocalDateTime.now());
	}
	
}
