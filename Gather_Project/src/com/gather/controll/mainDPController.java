package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.DesignDTOR;
import com.gather.entity.MemberDTO;
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
	public String teamList(HttpServletRequest request, Model model) {
		System.out.println("==================== mainDP.do Start ====================");//mainDP consol 경계선
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("logOK");
		int mIdx = member.getM_idx();							
		System.out.println("로그인 번호 확인 : " + mIdx);				//로그인 번호 확인
		session.setAttribute("mIdx", mIdx);						
		
		List<TeamDTO> list = service.listTeam(mIdx);			//회원번호로 팀 리스트 불러오기
		model.addAttribute("list", list);						//팀 리스트 다음 페이지로 보내기
		System.out.println("팀 리스트 사이즈 확인 : " + list.size());	//팀 리스트 사이즈 확인
		
		List<TeamDTO> confirmList = service.callConfrim(mIdx);	// 팀 초대 요청 리스트 받아오기
		model.addAttribute("confirmList", confirmList);			// 팀 초대 요청 리스트 다음 페이지로 보내기
			for (TeamDTO teamDTO : confirmList) {				// 팀 초대 요청 리스트 확인
				System.out.println("초대 요청을 보낸 팀 이름 : " + teamDTO.gettName()); 
			}
			
//==========	팀 리스트가 비어있지 않을 시 마지막으로 수정한 팀 불러오기	==========
		if (list.size() != 0) {									
			TeamDTO selTeam = service.getSelectTeam(mIdx);			// 마지막에 수정한 팀(tIdx,tName)
			int tIdx = selTeam.gettIdx();
			System.out.println("마지막에 수정한 팀의 번호" + tIdx);
			System.out.println("마지막에 수정한 팀의 이름" + selTeam.gettName());
			List<String> mlist = service.TeamMember(tIdx);		//팀 맴버 리스트
			List<String> clist = service.CallMember(tIdx);		//대기중인 팀 맴버 리스트
			model.addAttribute("tIdx", tIdx);
			model.addAttribute("tName", selTeam.gettName());
			model.addAttribute("mlist", mlist);
			model.addAttribute("clist", clist);
			
			//기획
			DesignDTOR des = service.getDesign(tIdx);					// 팀의 기획 정보((dIdx,dName)
			if(des != null) {
				//==========	디자인이 비어있지 않을 시 디자인 정보 불러오기	==========
				List<String> purp = service.designPurpose(des.getdIdx());	//기획 목적
				List<String> dCon = service.designContent(des.getdIdx());	//기획 내용(기능)
				model.addAttribute("des", des);
				model.addAttribute("purp", purp);
				model.addAttribute("dCon", dCon);
			}
			
			//진행
			List<WorkDTO> wlist = service.workList(tIdx);				//진행 객체 리스트
			if(wlist.size() != 0) {
				//==========	업무/진행이 비어있지 않을 시 업무/진행 정보 보내기	==========
				model.addAttribute("wlist", wlist);
			}
		}
		System.out.println("==================== mainDP.do End ====================");
		return "mainDP";
	}
	
	@RequestMapping(value = "/LastTeam.do")
	public String LastTeam(@RequestParam("mIdx") int mIdx, @RequestParam("tIdx") int tIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		int n = service.LastTeam(mIdx, tIdx);
		return "redirect:/mainDP.do";
	}
	
	@RequestMapping(value = "/LastTeamDel.do")
	public String LastTeamDel(@RequestParam("mIdx") int mIdx, @RequestParam("tIdx") int tIdx, Model model) {
		model.addAttribute("mIdx", mIdx);
		service.LastTeamDel(mIdx, tIdx);
		return "redirect:/mainDP.do";
	}
	
}
