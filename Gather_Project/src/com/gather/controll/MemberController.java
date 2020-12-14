package com.gather.controll;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gather.entity.MemberDTO;
import com.member.model.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	// 회원가입 클릭시 회원가입.jsp로 이동 -------------------------------------
	@RequestMapping(value="/join.do")
	public String join() {
		System.out.println("회원가입 창으로 이동");
		return "join";
	}
	
	// 아이디 중복확인 -------------------------------------
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(@RequestParam("userId") String user_id) {
		System.out.println("테스트: "+user_id);
		Integer n = memberService.selectMember(user_id);
		System.out.println("n: " + n);
		return n.toString();
	}
	
	// 회원가입 -------------------------------------
	@RequestMapping(value = "/insertJoin.do", method = RequestMethod.GET)
	public String insertJoin(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("회원가입");
		
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("user_id"));
		member.setPw(request.getParameter("inputPW"));
		member.setName(request.getParameter("inputName"));
		member.setPhone(request.getParameter("inputPhone"));
		
		int n = memberService.insertMember(member);
		
		if(n>0) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		return "join";
	}
	
}
