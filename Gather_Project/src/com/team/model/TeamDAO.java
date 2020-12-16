package com.team.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.CallingDTO;
import com.gather.entity.TeamDTO;

@Repository
public class TeamDAO {
	@Autowired
	private SqlSessionFactory factory;
	
	/* 팀만들기 */
	public int CreTeam(int mIdx, String tName) {
		SqlSession session=factory.openSession();
		session.insert("my.team-mapping.creTeam", tName);
		session.insert("my.team-mapping.creMyT", mIdx);
		int n = session.selectOne("my.team-mapping.getTIdx");
		session.close();
		return n;
	}
	public int CreLT(int mIdx, String tName) {
		return 0;
	}
	/* 팀 이름 수정하기 */
	public void UpTeamName(TeamDTO dto) {
		SqlSession session=factory.openSession();
		session.update("my.team-mapping.UpTeamName", dto);
		session.close();
	}
	/* 팀원 초대하기  */
	public int checkCall(CallingDTO dto) {//이미 초대되어 있는지 확인
		SqlSession session=factory.openSession();
		int n = 0;
		try {
			n = session.selectOne("my.team-mapping.checkCall", dto);
		} catch (NullPointerException e) {
			n=0;
		}
		session.close();
		return n;
	}
	public int checkMem(CallingDTO dto) {//이미 팀에 속해있는지 확인
		SqlSession session=factory.openSession();
		int n = 0;
		try {
			n = session.selectOne("my.team-mapping.checkMem", dto);
		} catch (NullPointerException e) {
			n=0;
		}
		session.close();
		return n;
	}
	public void callMem(CallingDTO dto) {//초대
		SqlSession session=factory.openSession();
		session.insert("my.team-mapping.addCalling", dto);
		session.close();
	}
	/* 초대에 응답하기 */
	public void confrim(TeamDTO dto) {
		SqlSession session=factory.openSession();
		session.insert("my.team-mapping.deleteCall", dto);
		session.insert("my.team-mapping.callAnswerYes", dto);
		session.close();
	}

	public void noConfrim(TeamDTO dto) {
		SqlSession session=factory.openSession();
		session.insert("my.team-mapping.deleteCall", dto);
		session.close();
	}
	/* 팀 탈퇴하기 */
	public void escapeTeam(Map<String, Integer> map) {
		SqlSession session=factory.openSession();
		session.delete("my.team-mapping.escapeTeam", map);
		session.close();
	}
	public int backMyTeam(int mIdx) {
		SqlSession session=factory.openSession();
		int n = 0;
		try {
			n = session.selectOne("my.team-mapping.backMyTeam", mIdx);
		} catch (NullPointerException e) {
			n=0;
		}
		session.close();
		return n;
	}
	

}
