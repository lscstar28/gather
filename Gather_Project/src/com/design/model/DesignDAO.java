package com.design.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.DesignDTO;

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

	//--------------------기획목적------------------------------------
	public List<DesignDTO> designPurpList(int dIdx) {
		return factory.openSession().selectList("my.designMapper.designPurpList", dIdx);
	}
	
	public void designPurpInsert(DesignDTO entity) {
		factory.openSession().insert("my.designMapper.designPurpInsert", entity);
	}

	public void designPurpDelete(int dp_Idx) {
		factory.openSession().delete("my.designMapper.designPurpDelete", dp_Idx);
	}
	public DesignDTO designPurpModify(DesignDTO entity) {
		return factory.openSession().selectOne("my.designMapper.designPurpModify", entity);
	}

	public void designPurpUpdate(DesignDTO entity) {
		factory.openSession().update("my.designMapper.designPurpUpdate", entity);
	}
	
	

	
	//--------------------기획내용------------------------------------
	public List<DesignDTO> designConList(int dIdx) {
		return factory.openSession().selectList("my.designMapper.designConList", dIdx);
	}
	
	public void designConInsert(DesignDTO entity) {
		factory.openSession().insert("my.designMapper.designConInsert", entity);
	}
	public void designConDelete(int dc_Idx) {
		factory.openSession().delete("my.designMapper.designConDelete", dc_Idx);
	}
	public DesignDTO designConModify(DesignDTO entity) {
		return factory.openSession().selectOne("my.designMapper.designConModify", entity);
	}
	public void designConUpdate(DesignDTO entity) {
		factory.openSession().update("my.designMapper.designConUpdate", entity);
	}





}