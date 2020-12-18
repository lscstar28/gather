package com.conference.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

	public void conferenceDelete(int cidx) {
		dao.conferenceDelete(cidx);
		
	}

	public ConferenceDTO conferenceModidy(int cidx) {
		return dao.conferenceModidy(cidx);
	}

	public void conferenceUpdate(ConferenceDTO entity) {
		dao.conferenceUpdate(entity);
	}

	
}
