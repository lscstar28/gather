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
	
	public List<TeamDTO> listTeam(int mIdx) {
		return dao.listTeam(mIdx);
	}

	public List<String> TeamMember(int lastTIdx) {
		return dao.TeamMember(lastTIdx);
	}

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

	public List<String> CallMember(int tIdx) {
		return dao.CallMember(tIdx);
	}

	public int getRn(int mIdx) {
		return  dao.getRn(mIdx);
	}

	public void LastTeam(int mIdx, int tIdx) {
		Map<String, Integer> mt = new HashMap<String, Integer>();
		mt.put("mIdx", mIdx);
		mt.put("tIdx", tIdx);
		dao.LastTeam(mt);
	}

}
