package com.mainDP.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gather.entity.ConferenceDTO;

@Service
public class ConferenceService {
	@Autowired
	private ConferenceDAO dao;
	
	public ConferenceService() {
		super();
	}

	public List<ConferenceDTO> conferenceList(Map<String, Integer> map) {
		return dao.conferenceList(map);
	}
//	public List<ConferenceDTO> conferenceList(int tIdx) {
//		return dao.conferenceList(tIdx);
//	}

	public void conferenceInsert(ConferenceDTO entity) {
		dao.conferenceInsert(entity);
	}

	public void conferenceDelete(int cidx) {
		dao.conferenceDelete(cidx);
		
	}

	public ConferenceDTO conferenceModidy(int cidx) {
		return dao.conferenceModidy(cidx);
	}

	public void conferenceUpdate(ConferenceDTO entity) {
		dao.conferenceUpdate(entity);
	}

	
	//페이지 처리----------------------------------------------------
	
	StringBuffer pagingHTML;
	
	public void makePagingHTML(int currentPage, int pageBlock, int pageSize){
		pagingHTML=new StringBuffer();
		
		int totalA=dao.getTotalConference();//총글수			
		int totalP=(totalA+pageSize-1)/pageSize;//총페이지수
	
		int startPage=((int)((currentPage-1)/pageBlock))*pageBlock+1;		
		int endPage=startPage+pageBlock-1;
				
		if(endPage>totalP){
			endPage=totalP;
		}		
		
		//----------------------------------------------------------------
		if(startPage>pageBlock){			
			pagingHTML.append("<a href='conference.do?tIdx=1&pg="
		+(startPage-pageBlock)+"'>["+"이전]</a>");
		}		
		
		for(int i=startPage;i<=endPage;i++){
			if(currentPage==i){
				pagingHTML.append("<a href='conference.do?tIdx=1&pg="
			                     +i+"'><font color=red>["+ i+ "]</font></a>");
			
			}else{
				pagingHTML.append("<a href='conference.do?tIdx=1&pg="
			                      +i+"'>["+i+"]</a>");
			}
		}
				
		if(endPage<totalP){
			pagingHTML.append("<a href='conference.do?tIdx=1&pg="
		+(startPage+pageBlock)+"'>["+"다음]</a>");
		}
	}
	
	public String getPagingHTML() {
		return pagingHTML.toString();
	}	
	
	//페이지 처리
	
}
