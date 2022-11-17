package com.javateam.TimeLabel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.javateam.TimeLabel.service.DTO.UserLoginServiceDTO;
import com.javateam.TimeLabel.service.DTO.UserSearchDTO;
import com.javateam.TimeLabel.service.DTO.UserUpdateServiceDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	// private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
    private UserService userService;

    private UserLoginServiceDTO loginService;

    // private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // 가입 화면
    // @GetMapping("/join")
    @RequestMapping(value="/join", method = RequestMethod.GET)
    public String joinGet() {
        log.info("############ 회원가입 페이지 진입 ############");
        // user폴더의 join.jsp가 실행됨.
        return "/user/join";
    }

    // 가입 요청
    @PostMapping("/join")
    public String joinPost(@Validated @ModelAttribute UserVO user, BindingResult bindingResult) {
        // 회원의 정보를 데이터베이스 전송
        log.info("############ 회원가입 서비스 실행 ############");
        
        log.info("UserVO: " + user);
        
        if (bindingResult.hasErrors()) {
        	log.error("폼 점검 에러 메시지 : " + bindingResult.getErrorCount());
        	log.error("폼 점검 에러 메시지 : " + bindingResult.toString());
            // 에러 발생시 다시 회원가입 화면으로 이동
            return "/user/join";
        }

        // 성공시 메인페이지로 이동
        userService.userJoin(user);
        log.info("############ 회원가입 성공 ############");
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

    // 회원 전체 리스트
    @GetMapping("/userList")
    public String getUserList(@Validated @ModelAttribute("userSearch") UserSearchDTO userSearch,
                              BindingResult bindingResult) {
        log.info("회원 목록 요청");

        if (bindingResult.hasErrors()) {
            // 회원 목록 볼떄 오류 발생시
            return "오류 발생시 이동할 페이지";
        }

        List<UserVO> userList = userService.findAllUser(userSearch);

        return "user/userList";
    }

    // 회원 정보 수정
    @GetMapping("/modifyUser")
    public String modifyUser(Model model,
                             @RequestParam(name = "userId", required = false) String userId,
                             @RequestParam(name = "userPw", required = false) String userName) {
        // required = true 일때는 값이 꼭들어와야함
        // required = false 일때는 없어도 가능함
        log.info("userid={}. userName={}", userId, userName);

        UserVO updateUser = userService.findUser(userId);

        return "user/회원정보변경폼";
    }

    // 회원 정보 수정 요청
    @PostMapping("/modifyUser")
    public String modifyUser(@Validated @ModelAttribute("user") UserUpdateServiceDTO user
            , BindingResult bindingResult) {
        log.info("회원 수정에 입력받은 데이터={}", user);
        if (bindingResult.hasErrors()) {
            log.info("값이 안들어왔거나 잘못된값이 들어옴");
            return "user/회원정보변경폼";
        }
        userService.updateUser(user);

        return "refirect:/user/userList";
    }

    // 회원 탈퇴 화면
    @GetMapping("/removeUser")
    public String removeUserDo(Model model,
                               @RequestParam(name = "userId", required = false) String userId,
                               @RequestParam(name = "result", required = true) String result
                               ) {
        model.addAttribute("title", "회원 처리 화면");
        model.addAttribute("userId", userId);
        if(result != null){
            model.addAttribute("result", result);
        }
        return "user/removeUser";
    }

    // 회원 탈퇴 처리
    @PostMapping("removeUser")
    public String removeUser(@RequestParam(name = "userId", required = false) String userId,
                             @RequestParam(name = "userPw", required = false) String userPw,
                             RedirectAttributes redirectAttributes) {
        log.info("회원 탈퇴 처리 userId ={}", userId);
        log.info("회원 탈퇴 처리 userPw ={}", userPw);

        UserVO user = userService.findUser(userId);

        if (user != null && user.getUserPw() != null && user.getUserPw().equals(user.getUserPw())) {
            log.info("회원 탈퇴 성공");
            userService.removeUser(String.valueOf(user));
            return "redirect:user/main";
        }
        redirectAttributes.addAttribute("userId", userId);
        redirectAttributes.addAttribute("result", "회원 정보가 일치하지 않습니다.");
        log.info("회원 탈퇴 처리 실패");
        return "/user/removeUser";
        
    }
    
}