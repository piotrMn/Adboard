package pl.coderslab.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	public void initaialize(Password constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.length() < 8 || value.length() > 30) {
			return false;
		}
		if (value.toLowerCase().equals(value)) {
			return false;
		}
		Pattern pattern1 = Pattern.compile("\\d{1,}");
		Matcher matcher1 = pattern1.matcher(value);
		if (!matcher1.find()) {
			return false;
		}
		Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9]{8,30}$");
		Matcher matcher2 = pattern2.matcher(value);
		if (!matcher2.matches()) {
			return false;
		}
		return true;

	}

}
