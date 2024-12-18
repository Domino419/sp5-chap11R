package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException ;
import spring.MemberRegisterService ;
import spring.RegisterRequest ;


@Controller
public class RegisterController {

    private MemberRegisterService memberRegisterService;

    public  void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }


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

    /**
     * method        : handleStep2
     * date          : 24-12-17
     * param         : Boolean agree - 약관 동의 여부
     *               : Model model - 뷰에 전달할 데이터를 저장하는 객체
     * return        : String - 다음 단계 페이지 또는 현재 단계 페이지 반환
     * description   : 약관 동의 여부를 확인하고, 동의 시 회원가입 두 번째 단계로 이동.
     *                 동의하지 않을 경우 첫 번째 단계로 돌아감.
     *                 http://localhost:8090/register/step1
     */
    @PostMapping("/register/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
        if (!agree) {
            return "register/step1";
        }
        return "register/step2";
    }


    @PostMapping("/register/step2T")
    public String handleStep2T(RegisterRequest regReq, @RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        if (!agree) {
            return "register/step1"; // 동의하지 않으면 step1로 이동
        }

        // 입력받은 값들이 모두 RegisterRequest에 담기므로 step3로 전달
        model.addAttribute("registerRequest", regReq);
        return "register/step3"; // step3 페이지로 이동
    }



    /**
     * method        : handleStep2Get
     * date          : 24-12-18
     * param         : 없음
     * return        : String - 리디렉션할 페이지 ("register/step1" 페이지로 리디렉션)
     */
    @GetMapping("/register/step2")
    public String handleStep2Get() {
       // return "register/step1";          //서버가 직접 페이지를 처리하여 응답을 보내는 방식 (step2로 남아있음)
        return "redirect:/register/step1";  //클라이언트에게 다시 요청을 보내도록 지시하는 방식 (url이 step1으로 바뀜)
    }


    /**
     * method        : handleStep3
     * date          : 24-12-18
     * param         : RegisterRequest regReq - 회원 등록 요청 객체
     * return        : String - 이동할 페이지 ("step3" 또는 "step2")
     */
    @PostMapping("/register/step3")
    public String handleStep3(RegisterRequest regReq) {
        System.out.println("Received name: " + regReq.getName());  // 서버에서 값 확인
        try {
            memberRegisterService.regist(regReq);
            return "/register/step3";    // 등록 성공 시 step3 페이지로 이동
        } catch (DuplicateMemberException ex) {
            return "register/step2";      // 중복된 회원이 존재하면 step2 페이지로 이동
        }
    }



}
