package com.soft1851.spring.boot.verify.annotation;

import com.soft1851.spring.boot.verify.validator.RegionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author CRQ
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RegionValidator.class)
public @interface Region {
    String message() default "Region值不在可选范围内";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
