package com.team.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.CallingDTO;
import com.gather.entity.TeamDTO;

@Service
public class TeamService {
	@Autowired
	TeamDAO dao;
	
	public int CreTeam(HttpServletRequest request, Enumeration e, int mIdx) {
		String tName =null;
		List<String> mList = new ArrayList<String>();
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String[] values = request.getParameterValues(name);		
			if(name.equals("tName")) {
				tName = values[0];
			}else {
				for (String string : values) {
					mList.add(string);
				}
			}
		}
		TeamDTO dto = new TeamDTO();
		dto.setmIdx(mIdx);
		dto.settName(tName);
		return dao.CreTeam(dto, mList);
	}

	public void UpTeam(int tIdx, int mIdx, String tName) {
		TeamDTO dto = new TeamDTO();
		dto.setmIdx(mIdx);
		dto.settName(tName);
		dto.settIdx(tIdx);
		dao.UpTeamName(dto);
	}

	public void callMem(int tIdx, int mIdx, String mId) {
		CallingDTO dto = new CallingDTO(tIdx, mId);
		dao.callMem(dto);
	}

}
