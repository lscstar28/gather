package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.DesignDTO;
import com.gather.entity.TeamDTO;
import com.gather.entity.WorkDTO;
import com.mainDP.model.MainDPService;

@Controller
public class mainDPController {
	@Autowired
	private MainDPService service;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/mainDP.do")
	public String teamList(HttpServletRequest request, @RequestParam("mIdx") int mIdx, Model model) {
		System.out.println("========================================");//console 경계선
		System.out.println("mIdx : " + mIdx);//로그인 번호 확인
		HttpSession session = request.getSession(true);
		session.setAttribute("mIdx", mIdx);
		
		List<TeamDTO> list = service.listTeam(mIdx);
		model.addAttribute("list", list);
		System.out.println("listsize : " + list.size());
		
//		List<String> callList = service.callConfrim(mIdx);
			
		if (list.size() != 0) {
			int rn = service.getRn(mIdx); // 마지막에 수정한 팀 보기
			System.out.println(rn);
			
			//팀 소개
			int tIdx = list.get(rn-1).gettIdx();		//마지막 팀 번호 변수
			System.out.println("main tidx" + tIdx);
			String name = list.get(rn-1).gettName();			//팀 이름
			List<String> mlist = service.TeamMember(tIdx);		//팀 맴버 리스트
			List<String> clist = service.CallMember(tIdx);		//대기중인 팀 맴버 리스트
			model.addAttribute("tName", name);
			model.addAttribute("mlist", mlist);
			model.addAttribute("clist", clist);
			model.addAttribute("tIdx", tIdx);
			
			//기획
			DesignDTO des = service.getDesign(tIdx);					//기획 객체
			if(des != null) {
				List<String> purp = service.designPurpose(des.getdIdx());	//기획 목적
				List<String> dCon = service.designContent(des.getdIdx());	//기획 내용(기능)
				model.addAttribute("des", des);
				model.addAttribute("purp", purp);
				model.addAttribute("dCon", dCon);
			}
			
			//진행
			List<WorkDTO> wlist = service.workList(tIdx);				//진행 객체 리스트
			if(wlist.size() != 0) {
				model.addAttribute("wlist", wlist);
			}
		}

		return "mainDP";
	}
	
	@RequestMapping(value = "/LastTeam.do")
	public String LastTeam(@RequestParam("mIdx") int mIdx, @RequestParam("tIdx") int tIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		int n = service.LastTeam(mIdx, tIdx);
		return "redirect:/mainDP.do";
	}
	
}
