package config;



import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource ;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


/**
 * class         : MvcConfig
 * date          : 24-12-17
 * description   : 스프링 MVC 관련 설정을 위한 클래스. 기본 서블릿 핸들링, 뷰 리졸버 및 뷰 컨트롤러 설정.
 */
@Configuration
@EnableWebMvc   // 스프링 MVC 기능을 활성화하는 애노테이션
public class MvcConfig implements WebMvcConfigurer  {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MvcConfig.class);

    /**
     * method        : configureDefaultServletHandling
     * date          : 24-12-17
     * param         : DefaultServletHandlerConfigurer configurer - 기본 서블릿 핸들링을 설정하는 객체
     * return        : void
     * description   : 기본 서블릿을 처리하도록 설정, 웹 애플리케이션에서 정적 자원을 처리할 수 있도록 함.
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * method        : configureViewResolvers
     * date          : 24-12-17
     * param         : ViewResolverRegistry registry - 뷰 리졸버를 설정하는 객체
     * return        : void
     * description   : JSP 파일을 뷰로 사용하기 위한 설정. 뷰의 경로와 확장자를 지정.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }


    /**
     * method        : messageSource
     * date          : 24-12-23
     * return        : MessageSource
     * description   : ResourceBundleMessageSource를 설정하여 애플리케이션의 메시지 리소스를 관리.
     *                 - basename: 프로퍼티 파일의 기본 경로 및 이름 설정 (messages.label)
     *                 - defaultEncoding: 프로퍼티 파일의 기본 인코딩 설정 (UTF-8) http://localhost:8080/register/step1
     *
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasename("messages.label_ko");
        ms.setDefaultEncoding("UTF-8");
        ms.setCacheSeconds(0);  // 캐시를 비활성화하여 파일 변경을 바로 반영

        log.info("Loading messages file: " + ms.getBasenameSet());
        return ms;
    }

}


//	/**
//	 * method        : addViewControllers
//	 * date          : 24-12-17
//	 * param         : ViewControllerRegistry registry - 뷰 컨트롤러를 등록하는 객체
//	 * return        : void
//	 * description   : 요청 URL에 대한 뷰 이름을 간단히 매핑하기 위한 설정. "/main" 요청에 대해 "main" 뷰를 반환.
//	 */
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/main").setViewName("main");
//	}

