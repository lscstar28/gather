package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.WorkDTO;
import com.mainDP.model.WorkService;

@Controller
public class workController {
	@Autowired
	private WorkService service;
	
	// 업무 리스트 보기
	@RequestMapping(value = "/work.do")
	public String workList(@RequestParam("tIdx") int tIdx, Model model) {
		List<WorkDTO> workList = service.workList(tIdx);
		model.addAttribute("workList",workList);
		model.addAttribute("tIdx",tIdx);
		return "work";
	}
	
	// work writer 로 가기
	@RequestMapping(value = "/workInsert.do")
	public String workInsert(@RequestParam("tIdx") int tIdx, Model model) {
		model.addAttribute("tIdx",tIdx);
		return "workwriter";
	}
	
	// 업무 추가하기
	@RequestMapping(value = "/workWriter.do")
	public String workWriter(HttpServletRequest request, Model model) {
		WorkDTO entity = new WorkDTO();
		entity.setT_idx(Integer.parseInt(request.getParameter("tIdx")));
		entity.setWork(request.getParameter("workTit"));
		entity.setW_Mem(request.getParameter("workMg"));
		service.workInsert(entity);
		return "writeOK";
	}
	
	// 업무상태 변경하기
	@RequestMapping(value = "/workStateChange.do")
	public String workStateChange(@RequestParam("widx") int widx, @RequestParam("wproc") int wproc, Model model) {
		System.out.println("widx: "+widx);
		System.out.println("wproc: "+wproc);
		service.workStateChange(widx,wproc);
		System.out.println("업데이트");
		return "writeOK";
	}
	
}
