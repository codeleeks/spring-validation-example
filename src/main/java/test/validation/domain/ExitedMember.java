package test.validation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class ExitedMember {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String birth;
    private boolean isBlackList;
    private LocalDate exitedDate;

    public boolean hasResiggnableDatePassed() {
        LocalDate beforeOneMonth = LocalDate.now().minusMonths(1);
        System.out.println("beforeOneMonth = " + beforeOneMonth);
        return exitedDate.isBefore(beforeOneMonth);
    }
}
