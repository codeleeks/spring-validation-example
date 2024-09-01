package test.validation.domain.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import test.validation.domain.ExitedMember;

import java.util.Optional;

public interface ExitedMemberRepository extends JpaRepository<ExitedMember, Long> {
    Optional<ExitedMember> findByNameAndBirth(String name, String birth);
}
