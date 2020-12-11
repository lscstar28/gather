package com.mainDP.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.DesignDTO;
import com.gather.entity.TeamDTO;

@Repository("mainDPDAO")
public class MainDPDAO {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<TeamDTO> listTeam(int mIdx) {
		System.out.println("dao midx : " + mIdx);
		return factory.openSession().selectList("my.gather-mapping.listTeam", mIdx);
	}

	public List<String> TeamMember(int lastTIdx) {
		System.out.println("dao lastTIdx : " + lastTIdx);
		return factory.openSession().selectList("my.gather-mapping.teamMember", lastTIdx);
	}

	public DesignDTO getDesign(int tIdx) {
		System.out.println("dao tIdx : " + tIdx);
		return factory.openSession().selectOne("my.gather-mapping.getDesign", tIdx);
	}

	public List<String> designPurpose(int dIdx) {
		System.out.println("dao dIdx : " + dIdx);
		return factory.openSession().selectList("my.gather-mapping.getdesignPurpose", dIdx);
	}

}
