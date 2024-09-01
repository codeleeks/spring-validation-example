package test.validation.web.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import test.validation.web.request.validator.NotDuplicateEmail;
import test.validation.web.request.validator.ReSignUpConstraint;

import java.util.Objects;

@Data
//@ReSignUpConstraint
public class SignUpRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$")
    private String phoneNumber;
    @Email
    @NotDuplicateEmail
    private String email;
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    @NotBlank
    @Size(min = 6, max = 20)
    private String retypePassword;
//    생년월일.
    @DateTimeFormat
    private String birth;

    @AssertTrue
    public boolean isPasswordSame() {
        System.out.println("SignUpRequest.isPasswordSame");
        return Objects.equals(this.password, this.retypePassword);
    }
}
