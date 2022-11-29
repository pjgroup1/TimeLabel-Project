package com.javateam.TimeLabel.session;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionManager;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("file:src/main/resources/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    public void setSessionTest(){
        
        // HttpServletResponse 인터페이스에 구현체들이 애매함 그럴떄 MockHttpServletResponse 사용
        // 가짜로 이런 기능들을 테스트 할수있도록 도와줌
        MockHttpServletResponse response = new MockHttpServletResponse();

        // 세션 생성
        UserVO user = new UserVO();
        sessionManager.createSession(user, response);

        // 요청에 응답 쿠키 저장 (웹 브라우저의 요청이라고 생각)
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies()); // mySessionId = ex) 21312e1e12r21

        // 세션 조회
        Object result = sessionManager.getSession(request);
        Assertions.assertThat(result).isEqualTo(user);

        // 세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        // null일때 성공
        Assertions.assertThat(expired).isNull();
        
    }
    
}
