package survey;


/**
 * class         : Respondent
 * date          : 24-12-17
 * description   : 설문 응답자의 정보를 저장하는 클래스.
 *                 나이와 거주지 정보를 관리.
 */

public class Respondent {

    private int age;                         // 나이
    private String location;                 // 거주지

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}


