package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    /**
     * method        : handleStep1
     * date          : 24-12-17
     * param         : none
     * return        : String - "register/step1" JSP 페이지 반환
     * description   : 회원가입 첫 번째 단계 페이지로 이동. [리스트11.5]
     * http://localhost:8080/register/step1
     *
     */
    @RequestMapping("/register/step1")
    public String handleStep1(){
        return "register/step1";
    }

}
