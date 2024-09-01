package test.validation.web.request.validator.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.validation.domain.repostiory.ExitedMemberRepository;
import test.validation.web.request.SignUpRequest;

@Component
@RequiredArgsConstructor
public class BlackListConstraintCondition implements ConstraintCondition<SignUpRequest> {
    private final ExitedMemberRepository exitedMemberRepository;

    @Override
    public ConditionResult validate(SignUpRequest data) {
        System.out.println("BlackListConstraintCondition.validate");
        boolean valid = exitedMemberRepository.findByNameAndBirth(data.getName(), data.getBirth())
                .map(em -> !em.isBlackList())
                .orElse(true);

        return ConditionResult.builder()
                .valid(valid)
                .source("BlackListConstraintCondition")
                .message(valid ? null : "블랙리스트입니다~")
                .build();

    }
}
