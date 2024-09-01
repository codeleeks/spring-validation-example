package test.validation.web.request.validator.v2;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import test.validation.web.request.SignUpRequest;
import test.validation.web.request.validator.BlackListConstraint;

@Slf4j
@RequiredArgsConstructor
public class BlackListConstraintValidator implements ConstraintValidator<BlackListConstraint, SignUpRequest> {
    private final MessageSource messageSource;
    @Override
    public void initialize(BlackListConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SignUpRequest value, ConstraintValidatorContext context) {
        System.out.println("BlackListConstraintValidator.isValid");
        log.info("value - {}", value);
//        throw new IllegalArgumentException(messageSource.getMessage("my.blacklist", null, null));
        return false;
    }
}
