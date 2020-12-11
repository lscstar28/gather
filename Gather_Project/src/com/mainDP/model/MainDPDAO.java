package com.mainDP.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.TeamDTO;

@Repository("mainDPDAO")
public class MainDPDAO {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<TeamDTO> listTeam(int mIdx) {
		System.out.println("dao midx : " + mIdx);
		return factory.openSession().selectList("my.gather-mapping.listTeam", mIdx);
	}

}
