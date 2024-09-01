package test.validation.web.request.validator.v1;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {})
@Target({TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface BusinessValidated {
    String message() default "default";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}