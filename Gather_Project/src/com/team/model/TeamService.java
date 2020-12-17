package com.team.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.CallingDTO;
import com.gather.entity.TeamDTO;

@Service
public class TeamService {
	@Autowired
	private TeamDAO dao;
	
	//-------------------- 팀 만들기 --------------------
	public int CreTeam(int mIdx, String tName) {
		int n= dao.CreTeam(mIdx, tName);
		return n;
	}

	//-------------------- 팀 이름 수정 --------------------
	public void UpTeam(int tIdx, int mIdx, String tName) {
		TeamDTO dto = new TeamDTO();
		dto.setmIdx(mIdx);
		dto.settName(tName);
		dto.settIdx(tIdx);
		dao.UpTeamName(dto);
	}

	//-------------------- 팀원 초대 --------------------
	public void callMem(int tIdx, int mIdx, String mId) {
		CallingDTO dto = new CallingDTO(tIdx, mId);
		int n1 = dao.checkCall(dto);
		int n2 = dao.checkMem(dto);
		if(n1+n2==0) {
			dao.callMem(dto);
		}
	}


	//-------------------- 초대 수락/거절 --------------------
	public void confrim(int tIdx, int mIdx, int answer) {
		TeamDTO dto = new TeamDTO();
		dto.setmIdx(mIdx);
		dto.settIdx(tIdx);
		if(answer == 1) {
			dao.confrim(dto);
		}else {
			dao.noConfrim(dto);
		}
	}

	
	public int escapeTeam(int tIdx, int mIdx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("tIdx", tIdx);
		map.put("mIdx", mIdx);
		dao.escapeTeam(map);
		return dao.backMyTeam(mIdx);		//L_TEAM 수정하기
	}


}
