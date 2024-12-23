package survey;

import java.util.Collections;
import java.util.List;

public class Question {

    private String title;
    private List<String> options ;

    public Question(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public Question(String title) {
        this(title, Collections.<String>emptyList());
    }

    public String getTitle() {
        return title;
    }

    public List<String> getOptions() {
        return options;
    }

    /**
     * method        : isChoice
     * date          : 24-12-09
     * return        : boolean
     * description   : options 리스트에 대한 null 체크 (null 이 아니면 true)
     */
    public boolean isChoice() {
        return options != null && !options.isEmpty();
    }
}
