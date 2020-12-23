package com.gather.controll;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.model.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService service;
	
	//-------------------- 팀 만들기 --------------------
	@RequestMapping(value = "/CreTeamPg.do")
	public String CreTeamPg(@RequestParam("mIdx") int mIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		return "team/CreTeamPg";
	}
	@RequestMapping(value="/CreTeam.do", method=RequestMethod.POST)
	public String CreTeam(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		String tName = request.getParameter("tName");
		int tIdx = service.CreTeam(mIdx, tName);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", tIdx);
		return "team/TeamOK";
	}
	
	//-------------------- 팀 이름 수정 --------------------
	@RequestMapping(value = "/UpTeamPg.do")
	public String UpTeamPg(@RequestParam("mIdx") int mIdx, @RequestParam("tName") String tName, @RequestParam("tIdx") int tIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tName", tName);
		model.addAttribute("tIdx", tIdx);
		return "team/UpTeamPg";
	}
	@RequestMapping(value="/UpTeam.do", method=RequestMethod.POST)
	public String UpTeamName(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		String tName = request.getParameter("tName");
		service.UpTeam(tIdx, mIdx, tName);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", tIdx);
		return "team/TeamOK";
	}
	
	//-------------------- 팀원 초대 --------------------
	@RequestMapping(value = "/callMemPg.do")
	public String callMemPg(@RequestParam("mIdx") int mIdx, @RequestParam("tIdx") int tIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", tIdx);
		return "team/callMemPg";
	}
	@RequestMapping(value="/callMem.do", method=RequestMethod.POST)
	public String callMem(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		String mId = request.getParameter("mId");
		service.callMem(tIdx, mIdx, mId);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", tIdx);
		return "team/TeamOK";
	}
	
	//-------------------- 초대 수락/거절 --------------------
	@RequestMapping(value="/confrim.do", method=RequestMethod.POST)
	public String confrim(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		int ptIdx = 0;
		try {
			ptIdx = Integer.parseInt(request.getParameter("ptIdx"));
		} catch (NumberFormatException e) {
			System.out.println("참여하고 있는 팀이 없습니다.");
			ptIdx = tIdx;
		}
		int answer = 1;
		service.confrim(tIdx, mIdx, answer);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", ptIdx);
		return "team/TeamOK";
	}
	@RequestMapping(value="/noConfrim.do", method=RequestMethod.POST)
	public String noConfrim(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		int ptIdx = 0;
		try {
			ptIdx = Integer.parseInt(request.getParameter("ptIdx"));
		} catch (NumberFormatException e) {
			System.out.println("참여하고 있는 팀이 없습니다.");
			ptIdx = tIdx;
		}
		int answer = 2;
		service.confrim(tIdx, mIdx, answer);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", ptIdx);
		return "team/noCon";
	}
	
	//-------------------- 팀 나가기 --------------------
	@RequestMapping(value="/escape.do")
	public String escapeTeam(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		int ptIdx = service.escapeTeam(tIdx, mIdx);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", ptIdx);
		if(ptIdx==0) {
			return "team/TeamInitialize";
		}
		return "team/TeamOK";
	}
	
}
