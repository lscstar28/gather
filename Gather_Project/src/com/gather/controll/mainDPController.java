package com.gather.controll;

import java.util.List;

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

	@RequestMapping(value = "/teamList.do")
	public String teamList(@RequestParam("mIdx") int mIdx, Model model) {
		System.out.println("mIdx : " + mIdx);
//		int mIdx = session.getAttribute("mIdx");
		List<TeamDTO> list = service.listTeam(mIdx);
		model.addAttribute("list", list);

		if (list != null) {
			//팀 소개
			int tIdx = list.size();
			String name = list.get(tIdx - 1).gettName();
			List<String> mlist = service.TeamMember(list.size());
			List<String> clist = service.CallMember(tIdx);
			model.addAttribute("tname", name);
			model.addAttribute("mlist", mlist);
			model.addAttribute("clist", clist);
			//기획
			DesignDTO des = service.getDesign(tIdx);
			List<String> purp = service.designPurpose(des.getdIdx());
			List<String> dCon = service.designContent(des.getdIdx());
			model.addAttribute("des", des);
			model.addAttribute("purp", purp);
			model.addAttribute("dCon", dCon);
			//진행
			List<WorkDTO> wlist = service.workList(tIdx);
			model.addAttribute("wlist", wlist);
		}

		return "mainDP";
	}
}
