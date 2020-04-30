package com.soft1851.spring.boot.verify.validator;

import com.soft1851.spring.boot.verify.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


/**
 * @author CRQ
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regexp = "^[1][3,4,5,7,8][0-9]{9}$";
        Pattern pattern = Pattern.compile(regexp);
        return pattern.matcher(value).matches();
    }
}
