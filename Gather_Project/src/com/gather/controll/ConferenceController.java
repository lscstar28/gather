package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.ConferenceDTO;

@Controller
public class ConferenceController {
	@Autowired
	private ConferenceService service;
	
	// 회의 리스트 보기
	@RequestMapping(value = "/conference.do")
	public String conferenceList(@RequestParam("tIdx") int tIdx, Model model) {
		List<ConferenceDTO> conferenceList = service.conferenceList(tIdx);
		model.addAttribute("conferenceList",conferenceList);
		model.addAttribute("tIdx",tIdx);
		return "conference/conference";
	}
	
	// conferenceInsert writer 로 가기
		@RequestMapping(value = "/conferenceInsert.do")
		public String conferenceInsert(@RequestParam("tIdx") int tIdx, Model model) {
			model.addAttribute("tIdx",tIdx);
			return "conference/conferenceWriter";
		}
		
	// 회의 추가하기
		@RequestMapping(value = "/CFWriter.do")
		public String CFWriter(HttpServletRequest request, Model model) {
			ConferenceDTO entity = new ConferenceDTO();
			entity.setT_idx(Integer.parseInt(request.getParameter("tIdx")));
			entity.setC_title(request.getParameter("CFTitle"));
			entity.setC_content(request.getParameter("CFContent"));
			service.conferenceInsert(entity);
			return "conference/conferenceWriteOK";
		}
		
	// 회의 삭제하기
			@RequestMapping(value = "/conferenceDelete.do")
			public String conferenceDelete(@RequestParam("cIdx") int cidx) {
				service.conferenceDelete(cidx);
				return "conference/conferenceWriteOK";
			}
			
	// 회의 수정하기 위한 write 가기
			@RequestMapping(value = "/conferenceModify.do")
			public String conferenceModify(@RequestParam("cIdx") int cidx, Model model) {
				ConferenceDTO entity = new ConferenceDTO();
				entity = service.conferenceModidy(cidx);
				model.addAttribute("entity",entity);
				return "conference/conferenceModify";
			}
	
	// 회의 수정하기
			@RequestMapping(value = "/CFModify.do")
			public String CFModify(HttpServletRequest request, Model model) {
				
				ConferenceDTO entity = new ConferenceDTO();
				entity.setC_Idx(Integer.parseInt(request.getParameter("cIdx")));
				entity.setC_title(request.getParameter("CFTitle"));
				entity.setC_content(request.getParameter("CFContent"));
				service.conferenceUpdate(entity);
				return "conference/conferenceWriteOK";
			}
			
}
