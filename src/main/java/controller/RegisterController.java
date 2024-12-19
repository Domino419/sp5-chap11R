package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import spring.DuplicateMemberException ;
import spring.MemberRegisterService ;
import spring.RegisterRequest ;


@Controller
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    private MemberRegisterService memberRegisterService;

    /**  git 검증 완료
     * method        : setMemberRegisterService
     * date          : 24-12-17
     * param         : MemberRegisterService memberRegisterService - 회원 등록 서비스를 주입받는 객체
     * return        : void
     * description   : MemberRegisterService를 주입받아 해당 서비스의 기능을 사용하도록 설정.
     */
    public void setMemberRegisterService(
            MemberRegisterService memberRegisterService) {
        log.info("setMemberRegisterService-- " );
        this.memberRegisterService = memberRegisterService;
    }


    /**  git 검증 완료
     * method        : handleStep1
     * date          : 24-12-17
     * param         : none
     * return        : String - "register/step1" JSP 페이지 반환
     * description   : 회원가입 첫 번째 단계 페이지로 이동. [리스트11.5]
     * http://localhost:8080/register/step1
     *
     */
    @RequestMapping("/register/step1")
    public String handleStep1() {
        log.info("handleStep1-- " );
        return "register/step1";
    }


    /**  git 검증 완료
     * method        : handleStep2  (교재버전 )
     * date          : 24-12-17
     * param         : Boolean agree - 약관 동의 여부
     *               : Model model - 뷰에 전달할 데이터를 저장하는 객체
     * return        : String - 다음 단계 페이지 또는 현재 단계 페이지 반환
     * description   : 약관 동의 여부를 확인하고, 동의 시 회원가입 두 번째 단계로 이동.
     *                 동의하지 않을 경우 첫 번째 단계로 돌아감.
     *                 http://localhost:8080/register/step1
     */
    @PostMapping("/register/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree,
            @ModelAttribute("registerRequest") RegisterRequest registerRequest, // 여기서 자동으로 모델에 추가됨
            Model model) {
        if (!agree) {
            return "register/step1";
        }
        // registerRequest 객체는 이제 모델에 자동으로 추가됨
        return "register/step2";
    }
    /**  git 검증 완료
     * method        : handleStep2Get
     * date          : 24-12-18
     * param         : 없음
     * return        : String - 리디렉션할 페이지 ("register/step1" 페이지로 리디렉션)
     */
    @GetMapping("/register/step2")
    public String handleStep2Get() {
       // return "register/step1";          //서버가 직접 페이지를 처리하여 응답을 보내는 방식 (step2로 남아있음)
        System.out.println("URL 직접 접근 하였으므로 redirect:/register/step1 ");
        return "redirect:/register/step1";  //클라이언트에게 다시 요청을 보내도록 지시하는 방식 (url이 step1으로 바뀜)
    }





/**  git 검증 완료
 * method        : handleStep3
 * date          : 24-12-18
 * param         : RegisterRequest regReq - 회원 등록 요청 객체
 * return        : String - 이동할 페이지 ("step3" 또는 "step2")
 */
@PostMapping("/register/step3")
 public String handleStep3(RegisterRequest regReq) {
    System.out.println("--------------------- RegisterRequest.getEmail: " + regReq.getEmail());

    try {
        memberRegisterService.regist(regReq);
        return "register/step3";  // 등록 성공 시 step3 페이지로 이동
    } catch (DuplicateMemberException ex) {
        return "register/step2";   // 중복 회원일 경우 step2 페이지로 이동
    }
}




}


///**
// * method        : handleStep3 (자습버전)
// * date          : 24-12-18
// * param         : RegisterRequest regReq - 회원 등록 요청 객체
// * return        : String - 이동할 페이지 ("step3" 또는 "step2")
// */
//@PostMapping("/register/step3")
//public String handleStep3(RegisterRequest regReq, Model model) {
//    // 서버에서 전달받은 데이터 확인 (디버깅용)
//    System.out.println("Received name: " + regReq.getName());
//    System.out.println("Received email: " + regReq.getEmail());
//    try {
//        // 회원 등록 서비스 호출
//        memberRegisterService.regist(regReq);
//        model.addAttribute("name", regReq.getName());  // 성공 시 사용자 데이터를 Model에 추가
//        model.addAttribute("email", regReq.getEmail());  // 성공 시 사용자 데이터를 Model에 추가
//        return "register/step3";  // 등록 성공 시 step3 페이지로 이동
//    } catch (DuplicateMemberException ex) {
//        return "register/step2";   // 중복 회원일 경우 step2 페이지로 이동
//    }
//}
//
///**
// * method        : handleStep2  (자습버전 )
// * date          : 24-12-17
// * param         : Boolean agree - 약관 동의 여부
// *               : Model model - 뷰에 전달할 데이터를 저장하는 객체
// * return        : String - 다음 단계 페이지 또는 현재 단계 페이지 반환
// * description   : 약관 동의 여부를 확인하고, 동의 시 회원가입 두 번째 단계로 이동.
// *                 동의하지 않을 경우 첫 번째 단계로 돌아감.
// *                 http://localhost:8080/register/step1
// */
//@PostMapping("/register/step2")
//public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
//    System.out.println("handleStep2 --  agree: " + agree);
//    if (!agree) {
//        System.out.println("handleStep2 --  register/step1  : " );
//        return "register/step1";
//    }
//    System.out.println("handleStep2 --  register/step2  : " );
//    return "register/step2";
//}
