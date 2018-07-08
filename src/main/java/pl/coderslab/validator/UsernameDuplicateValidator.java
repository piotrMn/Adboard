package pl.coderslab.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import pl.coderslab.service.GenericService;
import pl.coderslab.entity.User;


public class UsernameDuplicateValidator implements ConstraintValidator<UsernameDuplicate, String> {
	
	@Autowired
	GenericService<User> userService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<User> allUsers = userService.getAllEntities(User.class);
		for(User user : allUsers) {
			if(user.getUsername().equals(value)) {
				return false;
			}
		}
		return true;
	}

}
