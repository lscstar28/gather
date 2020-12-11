package com.mainDP.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.TeamDTO;

@Service
public class MainDPService {
	@Autowired
	private MainDPDAO dao;
	
	public List<TeamDTO> listTeam(int mIdx) {
		return dao.listTeam(mIdx);
	}

	public TeamDTO Team(int mIdx) {
		// TODO Auto-generated method stub
		return null;
	}

}
