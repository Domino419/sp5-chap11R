package survey;

import controller.RegisterController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/survey")
public class SurveyController {

    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);




    @GetMapping
    public String form(Model model) {
        List<Question> questions = createQuestions();
        model.addAttribute("questions", questions);
        log.info("---------------------------------------------------------------------SurveyController.class //form (GetMapping) ");
        log.info("---------------------------------------------------------------------SurveyController.class questions " +  questions );
        return "survey/surveyForm";
    }

    private List<Question> createQuestions() {
        Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("q1-서버","q1-프론트","q1-풀스택") );
        Question q2 = new Question("많이 사용 하는 개발 도구는 ?", Arrays.asList("q2-이클립스","q2-인텔리J","q2-서브라임") );
        Question q3 = new Question("하고 싶은 말을 적어주세요.");
        return Arrays.asList(q1,q2,q3) ;
    }



    @PostMapping
    public String submit(@ModelAttribute("ansData") AnsweredData data ){
        log.info("---------------------------------------------------------------------SurveyController.class //submit (PostMapping) ");
        return "survey/submitted";
    }

}


/*
수정 전
@GetMapping
    public String form(){
        log.info("---------------------------------------------------------------------SurveyController.class //form (GetMapping) ");
        return "survey/surveyForm";
    }
 */