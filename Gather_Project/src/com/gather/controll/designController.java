package com.gather.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gather.entity.DesignDTO;
import com.gather.entity.WorkDTO;
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
	
	//기획주제 작성화면으로 이동-----------------------------------------------
	@RequestMapping(value="/designInsert.do") 
	public String design(HttpServletRequest request, Model model) {
		String tIdx = request.getParameter("tIdx");
		model.addAttribute("tIdx",tIdx);			
		return "designWriter"; 
	}
	
	// 기획주제 추가하기
	@RequestMapping(value = "/designWriter.do")
	public String designWriter(HttpServletRequest request, Model model) {
		DesignDTO entity = new DesignDTO();
		entity.setT_idx(Integer.parseInt(request.getParameter("tIdx")));
		entity.setD_Name(request.getParameter("d_name"));
		service.designInsert(entity);
		return "designOK";
	}
	
	// 기획주제 삭제하기
	@RequestMapping(value = "/designDelete.do")
	public String designDelete(@RequestParam("dIdx") int didx) {
		System.out.println("didx: "+didx);
		service.designDelete(didx);
		return "designOK";
	}
	
	// 기획주제 수정 페이지로 이동
	@RequestMapping(value = "/designModify.do")
	public String movedesignModify(@RequestParam("dIdx") int didx, Model model) {
		DesignDTO entity = new DesignDTO();
		entity = service.designModidy(didx);
		model.addAttribute("entity",entity);
		return "designModify";
	}
	
	// 기획주제 수정하기
	@RequestMapping(value = "/designUpdate.do")
	public String designModify(HttpServletRequest request, Model model) {
		DesignDTO entity = new DesignDTO();
		entity.setD_Idx(Integer.parseInt(request.getParameter("dIdx")));
		entity.setD_Name(request.getParameter("d_name"));
		service.designUpdate(entity);
		return "designOK";
	}
	//---------------------------------------------------------------------------------------
	// 기획 목적

	// 기획목적 리스트 보기
	@RequestMapping(value = "/designPurp.do")
	public String designPurpList(@RequestParam("dIdx") int dIdx, Model model) {
		List<DesignDTO> designPurpList = service.designPurpList(dIdx);		
		model.addAttribute("designPurpList",designPurpList);
		model.addAttribute("dIdx",dIdx);
		return "designPurp";
	}
	
	//기획목적 작성화면으로 이동----------------------------------------------
	@RequestMapping(value="/designPurpInsert.do") 
	public String designPurp(HttpServletRequest request, Model model) {
		int dIdx = Integer.parseInt(request.getParameter("dIdx"));
		System.out.println("didx:123123 "+dIdx);
		model.addAttribute("dIdx",dIdx);
		return "designPurpWriter"; 
	}
	
	// 기획목적 추가하기
	@RequestMapping(value = "/designPurpWriter.do")
	public String designPurpWriter(HttpServletRequest request, Model model) {
		DesignDTO entity = new DesignDTO();
		entity.setD_Idx(Integer.parseInt(request.getParameter("dIdx")));
		entity.setD_Purp(request.getParameter("d_purp"));
		service.designPurpInsert(entity);
		model.addAttribute("entity",entity);
		return "designPurpOK";
	}
	
	// 기획목적 삭제하기
	@RequestMapping(value = "/designPurpDelete.do")
	public String designPurpDelete(@RequestParam("d_Purp") String purp, @RequestParam("dIdx") int dIdx,Model model) {
		System.out.println("d_Purp: "+purp);
		DesignDTO entity = new DesignDTO();
		entity.setD_Purp(purp);
		entity.setD_Idx(dIdx);
		service.designPurpDelete(entity);
		model.addAttribute("entity",entity);
		return "designPurpOK";
	}
	
	// 기획목적수정 페이지로 이동
	@RequestMapping(value = "/designPurpModify.do")
	public String movedesignPurpModify(@RequestParam("dp_Idx") int dp_Idx, Model model) {
		
		DesignDTO entity = new DesignDTO();
		entity.setDp_Idx(dp_Idx);
		
//		System.out.println("디피 아이디엑스: "+dp_Idx);
//		System.out.println("2: "+entity.getDp_Idx());

		entity = service.designPurpModify(entity);
		
		model.addAttribute("entity",entity);
//		System.out.println("가져오기: "+entity.getD_Purp());
		
		return "designPurpModify";
	}
	
	// 기획목적 수정하기
	@RequestMapping(value = "/designPurpUpdate.do")
	public String designPurpModify(HttpServletRequest request, Model model) {
		DesignDTO entity = new DesignDTO();
		
		entity.setDp_Idx(Integer.parseInt(request.getParameter("dp_Idx")));
		entity.setD_Idx(Integer.parseInt(request.getParameter("dIdx")));
		entity.setD_Purp(request.getParameter("d_purp"));		
		service.designPurpUpdate(entity);
		System.out.println("didx : " + entity.getD_Idx());
		System.out.println("dpidx : " + entity.getDp_Idx());
		
		model.addAttribute("entity",entity);
		
		return "designPurpOK";
	}

	
	//---------------------------------------------------------------------------------------
		// 기획 내용

		// 기획내용 리스트 보기
		@RequestMapping(value = "/designCon.do")
		public String designConList(@RequestParam("dIdx") int dIdx, Model model) {
			List<DesignDTO> designConList = service.designConList(dIdx);		
			model.addAttribute("designConList",designConList);
			model.addAttribute("dIdx",dIdx);
			return "designCon";
		}
		
		//기획내용 작성화면으로 이동----------------------------------------------
		@RequestMapping(value="/designConInsert.do") 
		public String designCon(HttpServletRequest request, Model model) {
			String dIdx = request.getParameter("dIdx");
			model.addAttribute("dIdx",dIdx);
			return "designConWriter"; 
		}
		
		// 기획내용 추가하기
		@RequestMapping(value = "/designConWriter.do")
		public String designConWriter(HttpServletRequest request, Model model) {
			DesignDTO entity = new DesignDTO();
			entity.setD_Idx(Integer.parseInt(request.getParameter("dIdx")));
			entity.setD_Con(request.getParameter("d_con"));
			service.designConInsert(entity);
			model.addAttribute("entity",entity);
			return "designConOK";
		}
		
		// 기획내용 삭제하기
		@RequestMapping(value = "/designConDelete.do")
		public String designConDelete(@RequestParam("d_Con") String con, @RequestParam("dIdx") int dIdx, Model model) {
			DesignDTO entity = new DesignDTO();
			entity.setD_Con(con);
			entity.setD_Idx(dIdx);
			service.designConDelete(entity);
			model.addAttribute("entity",entity);
			return "designConOK";
		}
		
		// 기획내용수정 페이지로 이동
		@RequestMapping(value = "/designConModify.do")
		public String movedesignConModify(@RequestParam("dc_Idx") int dc_Idx, Model model) {
			
			DesignDTO entity = new DesignDTO();
			entity.setDc_Idx(dc_Idx);

			entity = service.designConModify(entity);
			
			model.addAttribute("entity",entity);
			
			return "designConModify";
		}
		
		// 기획내용 수정하기
		@RequestMapping(value = "/designConUpdate.do")
		public String designConModify(HttpServletRequest request, Model model) {
			DesignDTO entity = new DesignDTO();
			
			entity.setDc_Idx(Integer.parseInt(request.getParameter("dc_Idx")));
			entity.setD_Idx(Integer.parseInt(request.getParameter("dIdx")));
			entity.setD_Con(request.getParameter("d_con"));		
			service.designConUpdate(entity);
			
			model.addAttribute("entity",entity);
			
			return "designConOK";
		}
	
}
