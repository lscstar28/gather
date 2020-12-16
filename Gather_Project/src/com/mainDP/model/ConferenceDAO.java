package com.mainDP.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
//		System.out.println("다오 팀번: "+entity.getC_Idx());
//		System.out.println("다오 회의제목: "+entity.getC_title());
//		System.out.println("다오 회의내용: "+entity.getC_content());
		
		factory.openSession().insert("my.conferenceMapper.conferenceInsert", entity);
		factory.openSession().close();
		System.out.println("회의 추가완료");
	}
	
}
