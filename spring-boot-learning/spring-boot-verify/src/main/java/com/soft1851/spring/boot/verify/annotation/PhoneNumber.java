package com.soft1851.spring.boot.verify.annotation;

import com.soft1851.spring.boot.verify.validator.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author CRQ
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
    String message() default "phoneNumber格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
