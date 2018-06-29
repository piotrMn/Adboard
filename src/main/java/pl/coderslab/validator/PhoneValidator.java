package pl.coderslab.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
	
	public void initaialize(Phone constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {
		if(phone.length() < 9) {
			return false;
		}
		String regex = "\\D+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		if(matcher.find()) {
			return false;
		}
		return true;
	}

}
