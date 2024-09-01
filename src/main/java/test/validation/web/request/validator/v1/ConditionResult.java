package test.validation.web.request.validator.v1;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ConditionResult {
    Boolean valid;
    String source;
    String message;
}
