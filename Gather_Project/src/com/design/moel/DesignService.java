package com.design.moel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.DesignDTO;
import com.gather.entity.DesignDTOR;
import com.gather.entity.WorkDTO;

@Service
public class DesignService {
	@Autowired
	private DesignDAO dao;

	public List<DesignDTOR> designList(int tIdx) {
		return dao.designList(tIdx);
	}

	public void designInsert(DesignDTO entity) {
		dao.designInsert(entity);
	}
	
}
