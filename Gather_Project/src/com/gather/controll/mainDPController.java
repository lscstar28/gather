package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.TeamDTO;
import com.mainDP.model.MainDPService;

@Controller
public class mainDPController {

	@Autowired
	private MainDPService service;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/teamList.do")
	public String teamList(@RequestParam("mIdx") int mIdx, Model model) {
		System.out.println("mIdx : "+mIdx);
//		int mIdx = session.getAttribute("mIdx");
		List<TeamDTO> list = service.listTeam(mIdx);
		model.addAttribute("list", list);
		
		for (TeamDTO ob : list) {
			System.out.println(ob.getmIdx() + " : " + ob.gettIdx() + " : " + ob.gettName());
		}
		return "mainDP";
	}
	
	@RequestMapping(value="/team.do")
	public String team(@RequestParam("mIdx") int mIdx, Model model) {
		System.out.println("mIdx : "+mIdx);
		TeamDTO dto = service.Team(mIdx);

		return "mainDP";
	}
}
