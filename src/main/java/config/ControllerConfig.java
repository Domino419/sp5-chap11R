package config;

import controller.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class         : ControllerConfig
 * date          : 24-12-18
 * description   : 컨트롤러 빈을 생성 및 설정하는 Spring Configuration 클래스
 */
@Configuration
public class ControllerConfig {


    /**
     * method        : registerController
     * date          : 24-12-18
     * return        : RegisterController - 회원 등록 컨트롤러 빈
     * description   : RegisterController 객체를 Spring Bean으로 등록
     */
    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }
}
