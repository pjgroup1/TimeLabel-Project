package com.javateam.TimeLabel.controller;

import java.util.List;
import java.util.Random;

import com.javateam.TimeLabel.mapper.UserMapper;
import com.javateam.TimeLabel.model.MailVO;
import com.javateam.TimeLabel.model.session.SessionConst;
import com.javateam.TimeLabel.service.MailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javateam.TimeLabel.model.UserVO;
import com.javateam.TimeLabel.service.UserService;

import javax.servlet.http.HttpServletRequest;


/**
 * Handles requests for the application home page.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("bcryptPasswordEncoder")
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("mailService")
    private MailService mailService;

    // private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // 가입 화면
    @GetMapping("/join")
    public String joinGet() {
        log.info("======= UserJoinPage ===== GET  =======>");

        // user폴더의 join.jsp가 실행됨.
        return "/user/join";
    }

    // 가입 요청
    @PostMapping("/join")
    public String joinPost(@Validated UserVO user, BindingResult bindingResult) {
        // 회원의 정보를 데이터베이스 전송
        log.info("======= UserJoinPage ===== Post  =======>");

        log.info("UserVO: " + user);

        if (bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            // 에러 발생시 다시 회원가입 화면으로 이동
            return "/user/join";
        }
        String userPassword = user.getUserPw();
        String encodePassword = passwordEncoder.encode(userPassword);
        user.setUserPw(encodePassword);

        // 성공시 메인페이지로 이동
        userService.userJoin(user);
        log.info("======= UserJoin Success =======>");
        return "redirect:/user/main";
    }

    // 아이디 중복 체크
    @ResponseBody
    @PostMapping("/userIdCheck")
    public String userIdCheck(String userId) {
        log.info("userIdCheck() 실행");
        // 아아디 존재시 1반환 없을시 0반환
        int result = userService.userIdCheck(userId);
        log.info("userId={}", result);
        if (result != 0) {
            //중복 아아디가 존재함
            return "fail";
        } else {
            return "success";
        }
    }

    // 회원 비밀번호 찾기
    @GetMapping("/findPw")
    public String findPwGet() {
        log.info("비밀번호 찾기 요청 페이지");

        return "user/findPw";
    }

    // 회원 비밀번호 찾기
    @PostMapping("/findPw")
    public String findPwPost(@RequestParam("userId") String userId,
                             @RequestParam("userEmail") String userEmail) {
        log.info("비밀번호 찾기 요청 페이지 정보 전송");

        UserVO findUserData = userService.findPwUser(userId);
        log.info("userEmail={}", userEmail);
        log.info("findUserData={}", findUserData.userEmail);
        if (userEmail.equals(findUserData.userEmail) == true) {
            log.info("이메일 확인 완료 메일 발송");
            String chPw = "";
            for (int i = 0; i < 10; i++) {
                Random rd = new Random();
                int num = rd.nextInt(62);
                char cha = ' ';
                if (num < 10) {
                    cha = (char) (num + '0');
                } else if (num < 36) {
                    cha = (char) (num - 10 + 'a');
                } else {
                    cha = (char) (num - 36 + 'A');
                }
                chPw += cha;
                log.info("cha={}, num={}", cha, num);

            }
            log.info("chPw={}", chPw);

            MailVO mail = new MailVO();
            mail.setMailFrom("sangyeobchu@gmail.com");
            mail.setMailTo(findUserData.userEmail);
            mail.setMailSubject("바뀐 비밀 번호 입니다.");
            mail.setMailContent("바뀐 비밀 번호는 = " + chPw + "입니다. 비밀번호를 로그인후 변경해주세요");
            mailService.sendEmail(mail);

            String encodePassword = passwordEncoder.encode(chPw);
            findUserData.setUserPw(encodePassword);
            log.info("비밀번호 변경후 인코딩 성공");
            userService.changePw(findUserData);
            return "redirect:/user/login";
        } else {
            log.info("이메일 정보가 다름");
            return "redirect:/user/findPw";
        }
    }

    // 회원 마이페이지
    @GetMapping("/myPage")
    public String myPage(HttpServletRequest request,
                         Model model) {

        log.info("==== user myPage ====>");
        UserVO user = (UserVO) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        model.addAttribute("user", user);
        return "user/myPage";
    }

    // 회원 정보 수정 요청
    @PostMapping("/modifyUser")
    public String modifyUser(@Validated UserVO user, BindingResult bindingResult,
                             HttpServletRequest request,
                             Model model) {
        log.info("====== modifyUserPage ======>");
        log.info("회원 수정에 입력받은 데이터={}", user);

        if (bindingResult.hasErrors()) {
            log.info("값이 안들어왔거나 잘못된값이 들어옴");
            log.info("bindingResult={}", bindingResult);
            return "redirect:/user/myPage";
        }

        String userPassword = user.getUserPw();
        String encodePassword = passwordEncoder.encode(userPassword);
        user.setUserPw(encodePassword);

        userService.updateUser(user);

        return "redirect:/user/myPage";
    }

    // 회원 탈퇴 화면
    @GetMapping("/removeUser")
    public String removeUserDo(Model model,
                               @RequestParam(name = "userId", required = false) String userId,
                               @RequestParam(name = "result", required = true) String result
    ) {
        model.addAttribute("title", "회원 처리 화면");
        model.addAttribute("userId", userId);
        if (result != null) {
            model.addAttribute("result", result);
        }
        return "user/removeUser";
    }

    // 회원 탈퇴 처리
    @PostMapping("removeUser")
    public String removeUser(@RequestParam(name = "userId", required = false) String userId,
                             @RequestParam(name = "userPw", required = false) String userPw,
                             int userIndex, RedirectAttributes redirectAttributes) {
        log.info("회원 탈퇴 처리 userId ={}", userId);
        log.info("회원 탈퇴 처리 userPw ={}", userPw);

        UserVO user = userService.findUser(userIndex);

        if (user != null && user.getUserPw() != null && user.getUserPw().equals(user.getUserPw())) {
            log.info("회원 탈퇴 성공");
            userService.removeUser(userIndex);
            return "redirect:user/main";
        }
        redirectAttributes.addAttribute("userId", userId);
        redirectAttributes.addAttribute("result", "회원 정보가 일치하지 않습니다.");
        log.info("회원 탈퇴 처리 실패");
        return "/user/removeUser";

    }

}