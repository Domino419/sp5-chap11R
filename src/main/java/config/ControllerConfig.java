package config;

import controller.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberRegisterService;
import survey.SurveyController;


/**
 * class         : ControllerConfig
 * date          : 24-12-18
 * description   : 컨트롤러 빈을 생성 및 설정하는 Spring Configuration 클래스
 */
@Configuration
public class ControllerConfig {

    private final MemberRegisterService memberRegSvc;

    // 생성자 주입
    public ControllerConfig(MemberRegisterService memberRegSvc) {
        this.memberRegSvc = memberRegSvc;
    }

    /**
     * method        : registerController
     * date          : 24-12-18
     * return        : RegisterController - 회원 등록 컨트롤러 빈
     */
    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegSvc); // memberRegSvc 주입
        return controller;
    }

    /**
     * method        : surveyController
     * date          : 24-12-17
     * return        : SurveyController - 설문 컨트롤러 빈
     */
    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

}
