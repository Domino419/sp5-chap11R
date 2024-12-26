## chap12. MVC 2 : 메세지, 커맨드 객체 검증

```
	<label>이메일:</label>
	<input type="email" name ="이메일">
	

<spring:message> 태그로 메시지 출력하기
문자열을 별도 파일에 작성하고 JSP 코드에서 이를 시용하려면 다음 작업을 하면 된다.

문자열을 담은 메시지 파일을 작성한다.
메시지 파일에서 값을 읽어오는 MessageSource 빈을 설정한다.
JSP 코드에서 spring:message 태그를 사용해서 메시지를 출력한다.


12/24 14:56
label.properties 작성, UTF-8로 작성하기 위해서 메모장에서 편집 후에 인텔리제이로 넘김.
인코딩 깨지는 거 처럼 보이는데 일단 냅둠.

서버 기동 중에서 
 javax.servlet.jsp.JspTagException: No message found under code 'member.register' for locale 'ko_KR'.
 org.springframework.web.servlet.tags.MessageTag.doEndTag(MessageTag.java:293) 

1.프로퍼티 파일 문제 같아서 인텔리제이 에디터에서 한글로 다시 입력함.
  프로퍼티 파일 수정했어도 http://localhost:8080/register/step1 접속시 동일하게 나옴.

2.<title><spring:message code="member.register" /></title>
 여기서 에러가 나는 거라서 프로퍼티 파일에서 member.register=register로 수정해봄.
label.properties을 삭제하고 다시 생성해보기.
```


12/24 22:09
프로퍼티 파일 로케일 에러 뜨는 거 아직 수정 중..
import org.springframework.context.support.ResourceBundleMessageSource;에서 
import org.springframework.context.support.ReloadableResourceBundleMessageSource ;로 바꿈
- 메시지 리소스가 자주 변경되지 않는 경우: ResourceBundleMessageSource를 사용.
- 메시지 리소스가 자주 변경되고 실시간 반영이 필요한 경우: ReloadableResourceBundleMessageSource를 사용.

프로퍼티 파일을 messages_ko_KR.properties 으로 수정해봄.
Caused by: javax.servlet.jsp.JspTagException: No message found under code 'member.register' for locale 'ko_KR'.
at org.springframework.web.servlet.tags.MessageTag.doEndTag(MessageTag.java:293)
인텔리제이 setting 수정 -  Editor -> File Encodings 에서 Properties Files (*.properties) 영역에서
- Default encoding for properties files: 를 UTF-8로 설정 /  Transparent native-to-ascii conversion 체크 



프로퍼티 파일 messages_ko_KR.properties 



아놕..미치네
프로퍼티 파일 제대로 읽어오질 못해서 파일 경로 맞는지 확인 messages/label_ko.properties 
set할 때 맞게 했는지 확인 setBasename("messages.label_ko")
maven 빌드 하고 나서 target/classes/messages에 있는지 확인
캐시 비활성화 시키는 거 까지 했음. ms.setCacheSeconds(0);  
인텔리제이 프로퍼티 파일 인코딩 UTF-8 로 수정했음.
그런데 안됨.  java.util.MissingResourceException: Can't find bundle for base name messages.label_ko, locale ko_KR 


강제로 메시지 소스 등록할 예정.

2024.12.24 23:57
javax.servlet.jsp.JspTagException: No message found under code 'member.register' for locale 'ko_KR'.
at org.springframework.web.servlet.tags.MessageTag.doEndTag(MessageTag.java:293)
아놕... 앙대앙대....


2024.12.26 17:13
이클립스에서 교재와 동일하게 프로퍼티 파일을 생성해서 인텔리로 가져옴. 어..된다.
아..step1에서 프로퍼티 파일 값 가져오는 걸 모두 하드코딩 해놔서 되는 거.
chap12에서 다시 진행해보기.

chap12는 프로퍼티 파일을 이클립스에서 만든 걸 가져왔음.
기존 예제소스를 그대로 다 복사함.
port는 8070 사용 하는 걸로 해서 http://localhost:8070/register/step1 

