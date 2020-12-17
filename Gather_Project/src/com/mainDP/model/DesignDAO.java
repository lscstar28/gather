package com.mainDP.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.DesignDTO;
import com.gather.entity.WorkDTO;

@Repository("designDAO")
public class DesignDAO {

	@Autowired
	private SqlSessionFactory factory;

	public List<DesignDTO> designList(int tIdx) {
		return factory.openSession().selectList("my.designMapper.designList", tIdx);
	}

	public void designInsert(DesignDTO entity) {
		factory.openSession().insert("my.designMapper.designInsert", entity);
	}

	public void designDelete(int didx) {
		factory.openSession().delete("my.designMapper.designDelete", didx);
	}

	public void designUpdate(DesignDTO entity) {
		factory.openSession().update("my.designMapper.designUpdate", entity);
	}

	public DesignDTO designModidy(int didx) {
		return factory.openSession().selectOne("my.designMapper.designModify", didx);
	}

}