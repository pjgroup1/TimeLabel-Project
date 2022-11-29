package com.javateam.TimeLabel.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javateam.TimeLabel.mapper.MemberMapper;
import com.javateam.TimeLabel.model.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberControllerTest {

	@Autowired
	/* private MemberMapper memberMapper; */
	SqlSession sqlSession;
	
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public void testDAO() {
//		log.info("memberMapperClass={}", memberMapper.getClass());
		
		MemberVO vo = sqlSession.getMapper(MemberMapper.class).suchMember("asd").get();
		log.info("test: " + vo);
		
		vo.setNAME("test1");
		vo.setId("fdddsxx");
		vo.setPW("1234");
		
		// memberMapper.save(vo);
	}
}
