package com.member.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.MemberDTO;

@Service("memberService")
public class MemberService {
	
	private MemberDAO memberDao;

	@Autowired
	public MemberService(MemberDAO memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	//아이디 중복체크 (Select)
	public int selectMember(String user_id) {
		return memberDao.selectMember(user_id);
	}
	
	//회원가입 (Insert)
	public int insertMember(MemberDTO member) {
		return memberDao.insertMember(member);
	}
	
}