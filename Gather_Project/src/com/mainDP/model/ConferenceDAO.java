package com.mainDP.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.ConferenceDTO;

@Repository("conferenceDAO")
public class ConferenceDAO {
	
	@Autowired
	private SqlSessionFactory factory;
//	private static SqlSessionFactory factory;
	
//	private static ConferenceDAO instance;
//	@Autowired
//	private ConferenceDAO instance;
//	
//	public static ConferenceDAO getInstance() {
////	@Autowired
////	public ConferenceDAO getInstance() {
//		if (instance == null) {
//			synchronized (ConferenceDAO.class) {
//				instance = new ConferenceDAO();
//			}
//		}
//		return instance;
//	}
	
	public int getTotalConference() {
		int n = 0;
		try {
			n = factory.openSession().selectOne("my.conferenceMapper.getTotalConference");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public List<ConferenceDTO> conferenceList(Map<String, Integer> map) {
		List<ConferenceDTO> list = factory.openSession().selectList("my.conferenceMapper.conferenceList1", map);
		factory.openSession().close();
		return list;
	}
	
	public ConferenceDTO conferenceModidy(int cidx) {
		return factory.openSession().selectOne("my.conferenceMapper.conferenceModify", cidx);	
	}
	
	public void conferenceInsert(ConferenceDTO entity) {
		factory.openSession().insert("my.conferenceMapper.conferenceInsert", entity);
	}

	public void conferenceDelete(int cidx) {
		factory.openSession().insert("my.conferenceMapper.conferenceDelete", cidx);	
	}


	public void conferenceUpdate(ConferenceDTO entity) {
		factory.openSession().update("my.conferenceMapper.conferenceUpdate", entity);
	}
	
}
