package com.javateam.TimeLabel.util;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res, Object obj) throws Exception {

        HttpSession session = req.getSession();
        UserVO user = (UserVO)session.getAttribute(SessionConst.LOGIN_USER);

        if(user == null) {
            res.sendRedirect("/user/login");
            logger.info("로그인을 해야 주문 페이지에 접속할 수 있습니다");
            
            return false;
        }


        return true;
    }
}
