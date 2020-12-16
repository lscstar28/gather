package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.ConferenceDTO;
import com.mainDP.model.ConferenceService;

@Controller
public class ConferenceController {
	@Autowired
	private ConferenceService service;
	
	// 업무 리스트 보기
	@RequestMapping(value = "/conference.do")
	public String conferenceList(@RequestParam("tIdx") int tIdx, Model model) {
		List<ConferenceDTO> conferenceList = service.conferenceList(tIdx);
		model.addAttribute("conferenceList",conferenceList);
		model.addAttribute("tIdx",tIdx);
		return "conference";
	}
	
	// conferenceInsert writer 로 가기
		@RequestMapping(value = "/conferenceInsert.do")
		public String conferenceInsert(@RequestParam("tIdx") int tIdx, Model model) {
			model.addAttribute("tIdx",tIdx);
			return "conferenceWriter";
		}
		
	// 업무 추가하기
		@RequestMapping(value = "/CFWriter.do")
		public String CFWriter(HttpServletRequest request, Model model) {
			
			ConferenceDTO entity = new ConferenceDTO();
			entity.setC_Idx(Integer.parseInt(request.getParameter("tIdx")));
			entity.setC_title(request.getParameter("CFTitle"));
			entity.setC_content(request.getParameter("CFContent"));
			service.conferenceInsert(entity);
			return "conferenceWriteOK";
		}
	
}
