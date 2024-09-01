package test.validation.web.request.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import test.validation.web.request.validator.v2.ReSignUpConstraintValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ReSignUpConstraintValidator.class)
@Target({TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface ReSignUpConstraint {
    String message() default "{my.resign}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int duration() default 30;
}
