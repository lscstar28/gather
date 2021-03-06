package com.mainDP.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.WorkDTO;

@Repository("workDAO")
public class WorkDAO {
	
	@Autowired
	private SqlSessionFactory factory;

	public List<WorkDTO> workList(int tIdx) {
		return factory.openSession().selectList("my.workMapper.workList", tIdx);
	}

	public void workInsert(WorkDTO entity) {
		factory.openSession().insert("my.workMapper.workInsert", entity);
	}

	public void workStateChange(int widx) {
		factory.openSession().update("my.workMapper.workStateChange", widx);
	}

	public void workStart(int widx) {
		factory.openSession().update("my.workMapper.workStart", widx);
		
	}

	public void workEnd(int widx) {
		factory.openSession().update("my.workMapper.workEnd", widx);
	}

	public void workDelete(int widx) {
		factory.openSession().delete("my.workMapper.workDelete", widx);
		
	}

	public WorkDTO workModidy(int widx) {
		return factory.openSession().selectOne("my.workMapper.workModify", widx);
	}

	public void workUpdate(WorkDTO entity) {
		factory.openSession().update("my.workMapper.workUpdate", entity);
	}
	
}
