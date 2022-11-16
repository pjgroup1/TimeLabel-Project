package com.javateam.TimeLabel.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.javateam.TimeLabel.model.MemberVO;

@Mapper
public interface MemberMapper {

	// test용
	public void memberSave(MemberVO member);
	
	// 회원 조회
	Optional<MemberVO> suchMember(String ID);
	
	// 회원 조회
	List<MemberVO> findAll(MemberVO member);
}
