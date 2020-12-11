package com.mainDP.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.DesignDTO;
import com.gather.entity.TeamDTO;

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

}
