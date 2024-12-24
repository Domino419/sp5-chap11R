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

>> 프로퍼티 파일 만들면서 로케일 에러 뜨는 거. 구글링 좀 더 해보고 수정할 것 !!!
> 325page 


