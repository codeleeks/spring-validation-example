package test.validation.web.request.validator.v1;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import test.validation.web.request.validator.v2.BusinessValidated;

import java.util.List;

public abstract class AbstractConstraintValidator<T> implements ConstraintValidator<BusinessValidated, T> {
    public AbstractConstraintValidator() {
        System.out.println("AbstractConstraintValidator.AbstractConstraintValidator");
    }

    @Override
    public void initialize(BusinessValidated constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {
        List<ConditionResult> list = getConditions().stream()
                .map(c -> c.validate(value))
                .filter(v -> !v.getValid())
                .toList();

        if (list.size() > 0) {
            for (ConditionResult conditionResult : list) {
                System.out.println("conditionResult = " + conditionResult);
            }
            throw new IllegalArgumentException(list.toString());
        }

        return true;
    }

    protected abstract List<ConstraintCondition<T>> getConditions();
}
