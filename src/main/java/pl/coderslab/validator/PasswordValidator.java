package pl.coderslab.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
	
	public static final String REGEX_1 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{8,30}$";
	
	public static final String REGEX_2 = "\\{bcrypt\\}.{60}";

	public void initaialize(Password constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		Pattern pattern1 = Pattern.compile(REGEX_1);
		Matcher matcher1 = pattern1.matcher(value);
		
		Pattern pattern2 = Pattern.compile(REGEX_2);
		Matcher matcher2 = pattern2.matcher(value);
		
		
		if (matcher1.matches() || matcher2.matches()) {
			return true;
		}
		return false;

	}

}
