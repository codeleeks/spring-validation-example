package test.validation.web;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.validation.web.request.SignUpRequest;
import test.validation.web.request.validator.v2.BusinessValidated;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
public class SignUpController {
    private final ApplicationContext ac;
    @PostMapping("/signup")
    public void signUp(@RequestBody @Validated @BusinessValidated SignUpRequest signUpRequest) {
        log.info("validation passed! - {}", signUpRequest);
    }

    @GetMapping
    public void get() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + bean);
        }
    }
}
