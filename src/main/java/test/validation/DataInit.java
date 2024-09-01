package test.validation;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.validation.domain.ExitedMember;
import test.validation.domain.Member;
import test.validation.domain.repostiory.ExitedMemberRepository;
import test.validation.domain.repostiory.MemberRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final MemberRepository memberRepository;
    private final ExitedMemberRepository exitedMemberRepository;
    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setEmail("codeleeks@naver.com");
        memberRepository.save(member);

        ExitedMember exitedMember = new ExitedMember();
        exitedMember.setName("abc");
        exitedMember.setBirth("2020-01-01");
        exitedMember.setExitedDate(LocalDate.of(2024, 7, 1));
        exitedMember.setBlackList(true);

        ExitedMember exitedMember1 = new ExitedMember();
        exitedMember1.setName("edf");
        exitedMember1.setBirth("2020-01-01");
        exitedMember1.setExitedDate(LocalDate.of(2024, 8, 8));

        ExitedMember exitedMember2 = new ExitedMember();
        exitedMember2.setName("hello");
        exitedMember2.setBirth("2020-01-01");
        exitedMember2.setExitedDate(LocalDate.of(2024, 8, 8));
        exitedMember2.setBlackList(true);


        exitedMemberRepository.save(exitedMember);
        exitedMemberRepository.save(exitedMember1);
        exitedMemberRepository.save(exitedMember2);
    }
}
