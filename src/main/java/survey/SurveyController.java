package survey;

import controller.RegisterController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/survey")   //http://localhost:8080/survey  >> Survey로 되어 있던 거 소문자 s로 수정함.
public class SurveyController {

    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);


    @GetMapping
    public String form(){
        log.info("---------------------------------------------------------------------SurveyController.class //form (GetMapping) ");
        return "survey/surveyForm";
    }


    @PostMapping
    public String submit(@ModelAttribute("ansData") AnsweredData data ){
        log.info("---------------------------------------------------------------------SurveyController.class //submit (PostMapping) ");
        return "survey/submitted";
    }

}
