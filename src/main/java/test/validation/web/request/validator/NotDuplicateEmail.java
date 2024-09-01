package test.validation.web.request.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = DuplicateEmailValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface NotDuplicateEmail {

    String message() default "Duplicated email is not allowed";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
