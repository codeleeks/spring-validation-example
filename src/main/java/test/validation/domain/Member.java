package test.validation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String birth;
}
