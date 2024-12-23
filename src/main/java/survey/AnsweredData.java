package survey;

import java.util.List;

/**
 * class         : AnsweredData
 * date          : 24-12-17
 * description   : 설문 응답 데이터와 응답자 정보를 저장하는 클래스.
 */


public class AnsweredData {

    private List<String> responses ;
    private Respondent res ;

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public Respondent getRes() {
        return res;
    }

    public void setRes(Respondent res) {
        this.res = res;
    }
}
