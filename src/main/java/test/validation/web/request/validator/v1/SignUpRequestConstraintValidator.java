package test.validation.web.request.validator.v1;

import lombok.RequiredArgsConstructor;
import test.validation.web.request.SignUpRequest;

import java.util.List;

@RequiredArgsConstructor
public class SignUpRequestConstraintValidator extends AbstractConstraintValidator<SignUpRequest> {
    private final List<ConstraintCondition<SignUpRequest>> conditions;

    @Override
    protected List<ConstraintCondition<SignUpRequest>> getConditions() {
        return this.conditions;
    }
}
