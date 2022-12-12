	package com.javateam.TimeLabel.controller;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.model.session.SessionManager;
import com.javateam.TimeLabel.service.UserService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@Controller
@RequestMapping("/user")
public class LoginLogoutController {

	private static final Logger log = LoggerFactory.getLogger(LoginLogoutController.class);

	@Autowired
    @Qualifier("userService")
    private UserService userService;

	@Autowired
    private SessionManager sessionManager;
	
	@Autowired
    @Qualifier("bcryptPasswordEncoder")
    BCryptPasswordEncoder passwordEncoder;
	
    // @GetMapping("/login")
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("user") UserVO user,
                        HttpServletRequest request) {
        log.info("============== 로그인 페이지로 이동 ================>");
        // 세션이 아직 남은 상태에서 login창으로 들어갈려고 하면 main사이트로 갈수있도록함
        UserVO userSession = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        if(userSession != null){
            if(userSession.getUserIndex() == 1){
                return "admin/main";
            }else{
                return "user/ProductList";
            }
        }
        return "login";

    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginAction(@Validated @ModelAttribute("user")
                                          UserVO user,
                              BindingResult bindingResult,
                              HttpServletResponse response,
                              HttpServletRequest request) throws SQLException, IOException {

    	log.info("로그인(post)");

        if(bindingResult.hasErrors()) {
            // 에러 발생시 다시 로그인 화면으로 이동
            return "login";

        }
        UserVO loginUser = userService.userLogin(user);
        boolean match= passwordEncoder.matches(user.getUserPw(), loginUser.getUserPw());
        log.info("user={}",loginUser);
        if(!match) {
            // 글로벌 오류
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('아이디 혹은 비밀번호가 다릅니다');</script>");
            out.flush();
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 다릅니다.");
            return "login";

        }        // 로그인 성공 처리
        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        /* getSession(true,false) true가 default임
        * true 세션이 있으면 기존 세션 반환, 세션이 없으면 새로운 세션 생성후 반환
        * false 세션이 있으면 기존 세션 반환, 세션이 없으면 새로운 세션 생성하지 않는다. null반환*/

        // 세션에 로그인 회원 정보를 보관
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        // 세션 600초간 유지
        session.setMaxInactiveInterval(600);
        // 세션 관리자를 통해 세션을 생성, 회원 데이터 보관(직접만든것)
        // sessionManager.createSession(loginUser, response);
        if(loginUser.getUserIndex()==1)
        	return "redirect:/admin/main";
        return "redirect:../ProductList";

    }

    @GetMapping(value="/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 세션 제거
    	log.info("로그아웃 실행!!!!!");
    	log.info("request={}", request);

        HttpSession session = request.getSession(false);

        if(session != null){
            session.invalidate();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('로그아웃 되었습니다.'); location.href = '/user/login'; </script>");
            out.flush();
            // 세션 없어지고 알림까지 나오는데 화면이 안나옴?????
        }
        log.info("로그아웃중");
    }


}
