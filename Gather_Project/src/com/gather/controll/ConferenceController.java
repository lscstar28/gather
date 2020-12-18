package com.gather.controll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 회의 리스트 보기
	@RequestMapping(value = "/conference.do")
	public String conferenceList(@RequestParam("tIdx") int tIdx, HttpServletRequest request, Model model) {
		
//		//데이터 가져오기
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("페이지: "+pg);
		//select DB
		int pageSize = 1;			// 한 페이지에 출력할 게시물 수
		int endNum=pg*pageSize;		
		int startNum=endNum-(pageSize-1);
		
		service.makePagingHTML(pg,4,pageSize);	// (x,3,y) 중 3은 페이지 숫자
		
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<ConferenceDTO> conferenceList = service.conferenceList(map);
		
		model.addAttribute("paging",service);
		model.addAttribute("pg",pg);
		model.addAttribute("conferenceList",conferenceList);
		model.addAttribute("tIdx",tIdx);
		return "conference";

	}
	
	// conferenceInsert writer 로 가기
		@RequestMapping(value = "/conferenceInsert.do")
		public String conferenceInsert(@RequestParam("tIdx") int tIdx, HttpServletRequest request, Model model) {
			int pg = Integer.parseInt(request.getParameter("pg"));
			model.addAttribute("pg",pg);
			model.addAttribute("tIdx",tIdx);
			return "conferenceWriter";
		}
		
	// 회의 추가하기
		@RequestMapping(value = "/CFWriter.do")
		public String CFWriter(HttpServletRequest request, Model model) {
			int pg = Integer.parseInt(request.getParameter("pg"));
			ConferenceDTO entity = new ConferenceDTO();
			entity.setT_idx(Integer.parseInt(request.getParameter("tIdx")));
			entity.setC_title(request.getParameter("CFTitle"));
			entity.setC_content(request.getParameter("CFContent"));
			service.conferenceInsert(entity);
			
			model.addAttribute("pg",pg);
			return "conferenceWriteOK";
		}
		
	// 회의 삭제하기
			@RequestMapping(value = "/conferenceDelete.do")
			public String conferenceDelete(@RequestParam("cIdx") int cidx,HttpServletRequest request, Model model) {
				int pg = Integer.parseInt(request.getParameter("pg"));
				service.conferenceDelete(cidx);
				model.addAttribute("pg",pg);
				return "conferenceWriteOK";
			}
			
	// 회의 수정하기 위한 write 가기
			@RequestMapping(value = "/conferenceModify.do")
			public String conferenceModify(@RequestParam("cIdx") int cidx, HttpServletRequest request, Model model) {
				int pg = Integer.parseInt(request.getParameter("pg"));
				ConferenceDTO entity = new ConferenceDTO();
				entity = service.conferenceModidy(cidx);
				model.addAttribute("entity",entity);
				model.addAttribute("pg",pg);
				return "conferenceModify";
			}
	
	// 회의 수정하기
			@RequestMapping(value = "/CFModify.do")
			public String CFModify(HttpServletRequest request, Model model) {
				int pg = Integer.parseInt(request.getParameter("pg"));
				ConferenceDTO entity = new ConferenceDTO();
				entity.setC_Idx(Integer.parseInt(request.getParameter("cIdx")));
				entity.setC_title(request.getParameter("CFTitle"));
				entity.setC_content(request.getParameter("CFContent"));
				service.conferenceUpdate(entity);
				model.addAttribute("pg",pg);
				return "conferenceWriteOK";
			}
			
}
