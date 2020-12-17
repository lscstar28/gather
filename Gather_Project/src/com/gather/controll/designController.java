package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.design.model.DesignService;
import com.gather.entity.DesignDTO;
import com.gather.entity.DesignDTOR;


@Controller
public class designController {
	@Autowired
	private DesignService service;
	
	// 기획 리스트 보기
	@RequestMapping(value = "/design.do")
	public String designList(@RequestParam("tIdx") int tIdx, Model model) {
		List<DesignDTOR> designList = service.designList(tIdx);
		model.addAttribute("designList",designList);
		model.addAttribute("tIdx",tIdx);
		return "design";
	}
	
	//기획 작성화면으로 이동-----------------------------------------------
	@RequestMapping(value="/designInsert.do") 
	public String design(HttpServletRequest request, Model model) {
		System.out.println("param" + request.getParameter("tIdx"));
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		model.addAttribute("tIdx",tIdx);			
		return "design/creDesign"; 
	}
	
	// 기획 추가하기
	@RequestMapping(value = "/designWriter.do", method=RequestMethod.POST)
	public String designWriter(HttpServletRequest request, Model model) {
		DesignDTO entity = new DesignDTO();
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		
		entity.setT_idx(tIdx);
		entity.setD_Name(request.getParameter("d_name"));
		System.out.println("팀 번호와 기획 주제 : " + entity.getT_idx() + " / " + entity.getD_Name());
		service.designInsert(entity);
		return "designOK";
	}
}
