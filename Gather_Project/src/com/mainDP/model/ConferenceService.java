package com.mainDP.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.ConferenceDTO;


@Service
public class ConferenceService {
	@Autowired
	private ConferenceDAO dao;

	public List<ConferenceDTO> conferenceList(int tIdx) {
		return dao.conferenceList(tIdx);
	}

	public void conferenceInsert(ConferenceDTO entity) {
		dao.conferenceInsert(entity);
	}

	
}
