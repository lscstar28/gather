package com.team.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.CallingDTO;
import com.gather.entity.TeamDTO;

@Repository
public class TeamDAO {
	@Autowired
	private SqlSessionFactory factory;
	
	public int CreTeam(TeamDTO dto, List<String> mList) {
		System.out.println("==========dao 확인==========");
		System.out.println("dao dto" + dto.getmIdx() + " , " +dto.gettName());
		factory.openSession().insert("my.team-mapping.creTeam", dto);
		factory.openSession().insert("my.team-mapping.creMyT", dto);
		for (String mId : mList) {
			factory.openSession().insert("my.team-mapping.calling", mId);
			System.out.println("dao mid : " + mId);
		}
		return factory.openSession().selectOne("my.team-mapping.getTIdx");
	}

	public void UpTeamName(TeamDTO dto) {
		factory.openSession().update("my.team-mapping.UpTeamName", dto);
	}

	public void callMem(CallingDTO dto) {
		factory.openSession().insert("my.team-mapping.addCalling", dto);
	}

}
