package pl.coderslab.rest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Comment;
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
		List<Comment> comments = new ArrayList<>();
		comments = specificService.getCommentsByAdId(id);
		Collections.sort(comments);
		return comments;
	}
	
	@PostMapping("/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public Comment addComment(@RequestBody Comment comment) {
		specificService.saveComment(comment);
		return comment;
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
