package test.validation.web.request.validator.v2;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import test.validation.web.request.SignUpRequest;
import test.validation.web.request.validator.ReSignUpConstraint;

@Slf4j
@RequiredArgsConstructor
public class ReSignUpConstraintValidator implements ConstraintValidator<ReSignUpConstraint, SignUpRequest> {
    private final MessageSource messageSource;

    @Override
    public boolean isValid(SignUpRequest value, ConstraintValidatorContext context) {
        System.out.println("ReSignUpConstraintValidator.isValid");
        log.info("value - {}", value);
//        throw new IllegalArgumentException(messageSource.getMessage("my.resign", new Object[]{"30"}, null));
        return false;
    }
}
