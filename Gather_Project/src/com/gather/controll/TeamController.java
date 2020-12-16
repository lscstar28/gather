package com.gather.controll;

import java.util.Enumeration;

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
	
	@RequestMapping(value = "/CreTeamPg.do")
	public String CreTeamPg(@RequestParam("mIdx") int mIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		return "team/CreTeamPg";
	}
	@RequestMapping(value="/CreTeam.do", method=RequestMethod.POST)
	public String CreTeam(HttpServletRequest request, Model model) {
		int mIdx = Integer.parseInt(request.getParameter("mIdx"));
		System.out.println(mIdx);
		Enumeration e = request.getParameterNames();
		int tIdx = service.CreTeam(request, e, mIdx);
		model.addAttribute("mIdx", mIdx);
		model.addAttribute("tIdx", tIdx);
		return "team/TeamOK";
	}
	
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
	
}
