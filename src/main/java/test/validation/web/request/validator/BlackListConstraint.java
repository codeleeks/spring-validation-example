package test.validation.web.request.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import test.validation.web.request.validator.v2.BlackListConstraintValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = BlackListConstraintValidator.class)
@Target({TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface BlackListConstraint {
    String message() default "{my.blacklist}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
