package test.validation.web.request.validator.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import test.validation.domain.repostiory.ExitedMemberRepository;
import test.validation.web.request.SignUpRequest;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ReSignUpConstraintCondition implements ConstraintCondition<SignUpRequest> {
    private final ExitedMemberRepository exitedMemberRepository;
    private final MessageSource messages;

    @Override
    public ConditionResult validate(SignUpRequest data) {
        System.out.println("ReSignUpConstraintCondition.validate");
        System.out.println("messages = " + messages);
        String message = messages.getMessage("my.resign", new Object[]{"30"}, null);
        String message2 = messages.getMessage("my.resign", new Object[]{"30"}, Locale.ENGLISH);
        System.out.println("message = " + message);
        System.out.println("message2 = " + message2);
        Boolean valid = exitedMemberRepository.findByNameAndBirth(data.getName(), data.getBirth())
                .map(em -> em.hasResiggnableDatePassed())
                .orElse(true);



        return ConditionResult.builder()
                .valid(valid)
                .source("ReSignUpConstraintCondition")
                .message(valid ? null : "{my.resign}")
//                .message(valid ? null : "탈퇴한지 30일이 지나지 않았습니다.")
                .build();
    }
}
