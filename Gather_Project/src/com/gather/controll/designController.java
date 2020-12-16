package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.DesignDTO;
import com.mainDP.model.DesignService;


@Controller
public class designController {
	@Autowired
	private DesignService service;
	
	// 기획 리스트 보기
	@RequestMapping(value = "/design.do")
	public String designList(@RequestParam("tIdx") int tIdx, Model model) {
		List<DesignDTO> designList = service.designList(tIdx);
		model.addAttribute("designList",designList);
		model.addAttribute("tIdx",tIdx);
		return "design";
	}
	
	//기획 작성화면으로 이동-----------------------------------------------
	@RequestMapping(value="/designInsert.do") 
	public String design(HttpServletRequest request, Model model) {
		
		String tIdx = request.getParameter("tIdx");
		model.addAttribute("tIdx",tIdx);			
		return "designWriter"; 
	}
	
	// 기획 추가하기
	@RequestMapping(value = "/designWriter.do")
	public String designWriter(HttpServletRequest request, Model model) {
		DesignDTO entity = new DesignDTO();
		entity.setT_idx(Integer.parseInt(request.getParameter("tIdx")));
		entity.setD_Name(request.getParameter("d_name"));
		entity.setD_Purp(request.getParameter("d_purp"));
		entity.setD_Con(request.getParameter("d_con"));
		
		service.designInsert(entity);
		return "designOK";
	}
}
