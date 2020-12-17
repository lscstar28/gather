package com.mainDP.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.DesignDTO;
import com.gather.entity.TeamDTO;
import com.gather.entity.WorkDTO;

@Service
public class MainDPService {
	@Autowired
	private MainDPDAO dao;
	
	// ========== 팀 리스트 불러오기 ==========
	public List<TeamDTO> listTeam(int mIdx) {
		return dao.listTeam(mIdx);
	}
	
	// ========== 마지막에 수정했던 팀의 tIdx, tName 가져오기 ==========	
	public TeamDTO getSelectTeam(int mIdx) {
		return dao.getSelectTeam(mIdx);
	}

	// ========== 팀에 소속된 맴버 리스트 가져오기 ==========	
	public List<String> TeamMember(int lastTIdx) {
		return dao.TeamMember(lastTIdx);
	}

	// ========== 초대 요청 대기중인 맴버 리스트 가져오기 ==========	
	public List<String> CallMember(int tIdx) {
		return dao.CallMember(tIdx);
	}

	// ========== 팀 기획 정보(기획 번호, 기획 주제) 가져오기 ==========	
	public DesignDTO getDesign(int tIdx) {
		return dao.getDesign(tIdx);
	}

	public List<String> designPurpose(int dIdx) {
		return dao.designPurpose(dIdx);
	}

	public List<String> designContent(int dIdx) {
		return dao.designContent(dIdx);
	}

	public List<WorkDTO> workList(int tIdx) {
		return dao.workList(tIdx);
	}




	public int LastTeam(int mIdx, int tIdx) {
		Map<String, Integer> mt = new HashMap<String, Integer>();
		mt.put("mIdx", mIdx);
		mt.put("tIdx", tIdx);
		int n = dao.LastTeam(mt);
		System.out.println("service" + n);
		if(n==1) {
			return n;
		}else {
			return dao.creLastTeam(mt);
		}
	}

	public List<TeamDTO> callConfrim(int mIdx) {
		return dao.callConfrim(mIdx);
	}

	public int LastTeamDel(int mIdx, int tIdx) {
		return dao.LastTeamDel(mIdx);
	}

}
