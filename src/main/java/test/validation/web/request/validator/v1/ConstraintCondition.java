package test.validation.web.request.validator.v1;

public interface ConstraintCondition<T> {
    ConditionResult validate(T data);
}
