package com.javateam.TimeLabel.persistance;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.javateam.TimeLabel.mapper.MemberMapper;
import com.javateam.TimeLabel.mapper.UserMapper;
import com.javateam.TimeLabel.model.MemberVO;
import com.javateam.TimeLabel.model.UserVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration({"file:src/main/resources/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MybatisTest {

	/*
	 * @Autowired private MemberMapper member;
	 */
	@Autowired(required=true)
	@Qualifier("memberDAO")
	private MemberMapper mm;
	
	@Test
	public void save() {
		MemberVO me = new MemberVO(); 
		me.setId("아이디1");
		me.setPW("비밀번호");
		me.setNAME("이름");
		
//		log.info("VO:{}", me);
		/*mm.memberSave(me);*/
			
	}
	
}
