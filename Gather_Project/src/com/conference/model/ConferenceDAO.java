package com.conference.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.gather.entity.ConferenceDTO;

@Repository("conferenceDAO")
public class ConferenceDAO {
	
	@Autowired
	private SqlSessionFactory factory;

	public List<ConferenceDTO> conferenceList(int tIdx) {
		List<ConferenceDTO> list = factory.openSession().selectList("my.conferenceMapper.conferenceList", tIdx);
		factory.openSession().close();
		return list;
	}

	public void conferenceInsert(ConferenceDTO entity) {
		factory.openSession().insert("my.conferenceMapper.conferenceInsert", entity);
	}

	public void conferenceDelete(int cidx) {
		factory.openSession().insert("my.conferenceMapper.conferenceDelete", cidx);	
	}

	public ConferenceDTO conferenceModidy(int cidx) {
		return factory.openSession().selectOne("my.conferenceMapper.conferenceModify", cidx);	
	}

	public void conferenceUpdate(ConferenceDTO entity) {
		factory.openSession().update("my.conferenceMapper.conferenceUpdate", entity);
	}
	
}
