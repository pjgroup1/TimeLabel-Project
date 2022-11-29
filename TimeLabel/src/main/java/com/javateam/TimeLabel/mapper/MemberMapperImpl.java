package com.javateam.TimeLabel.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javateam.TimeLabel.model.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository("memberDAO")
public class MemberMapperImpl implements MemberMapper{
  
  
  // @Autowired 
  // private MemberMapper memberMapper;
  
  
  @Autowired 
  private SqlSession ss;
  
  
  private static final String namespace="com.javateam.TimeLabel.mapper.MemberMapper"; // memberMapper 의namespace
  
  @Override 
  public void memberSave(MemberVO vo) { 
	 // log.info("MemberMapper class={}", memberMapper.getClass()); memberMapper.memberSave(vo);
	  ss.getMapper(MemberMapper.class).memberSave(vo);
  
  }
  
  
  @Override 
  public Optional<MemberVO> suchMember(String id) { 
	  MemberVO member= ss.getMapper(MemberMapper.class).suchMember(id).get(); 
	  
	  return Optional.ofNullable(member); 
  }
  
  
  @Override 
  public List<MemberVO> findAll(MemberVO member) {
  
	  return null; 
  }
  
}