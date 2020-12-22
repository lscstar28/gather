package com.design.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.DesignDTO;

@Service
public class DesignService {
	@Autowired
	private DesignDAO dao;

	
	//-----------------기획 주제
	
	public List<DesignDTO> designList(int tIdx) {
		return dao.designList(tIdx);
	}

	public void designInsert(DesignDTO entity) {
		dao.designInsert(entity);
	}

	public void designDelete(int didx) {
		dao.designDelete(didx);
	}

	public void designUpdate(DesignDTO entity) {
		dao.designUpdate(entity);
	}

	
	
	//-----------------기획 목적
	
	public List<DesignDTO> designPurpList(int dIdx) {
		return dao.designPurpList(dIdx);
	}
	
	public void designPurpInsert(DesignDTO entity) {
		dao.designPurpInsert(entity);
	}

	public void designPurpDelete(int dp_Idx) {
		dao.designPurpDelete(dp_Idx);	
	}
	
	public DesignDTO designPurpModify(DesignDTO entity) {
		return dao.designPurpModify(entity);
	}
	
	public void designPurpUpdate(DesignDTO entity) {
		dao.designPurpUpdate(entity);
	}

	

	
	
	//-----------------기획 내용
	public List<DesignDTO> designConList(int dIdx) {
		return dao.designConList(dIdx);
	}
	
	public void designConInsert(DesignDTO entity) {
		dao.designConInsert(entity);
	}
	public void designConDelete(int dc_Idx) {
		dao.designConDelete(dc_Idx);	
	}

	public DesignDTO designConModify(DesignDTO entity) {
		return dao.designConModify(entity);
	}
	
	public void designConUpdate(DesignDTO entity) {
		dao.designConUpdate(entity);
	}
	
	
	
}
