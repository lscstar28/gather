package com.design.moel;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gather.entity.DesignDTO;
import com.gather.entity.DesignDTOR;

@Repository("designDAO")
public class DesignDAO {

	@Autowired
	private SqlSessionFactory factory;

	public List<DesignDTOR> designList(int tIdx) {
		return factory.openSession().selectList("my.designMapper.designList", tIdx);
	}

	public void designInsert(DesignDTO entity) {
		factory.openSession().insert("my.designMapper.designInsert", entity);
	}
}