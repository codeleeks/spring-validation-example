package test.validation.web.request.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import test.validation.domain.repostiory.MemberRepository;
import test.validation.web.request.validator.NotDuplicateEmail;

public class DuplicateEmailValidator implements ConstraintValidator<NotDuplicateEmail, String> {
    private final MemberRepository memberRepository;
    public DuplicateEmailValidator(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void initialize(NotDuplicateEmail constraintAnnotation) {
        System.out.println("DuplicateEmailValidator.initialize");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return memberRepository.findByEmail(value)
                .isEmpty();
    }
}
