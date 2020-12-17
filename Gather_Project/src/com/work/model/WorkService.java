package com.work.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.entity.WorkDTO;

@Service
public class WorkService {
	@Autowired
	private WorkDAO dao;

	public List<WorkDTO> workList(int tIdx) {
		return dao.workList(tIdx);
	}

	public void workInsert(WorkDTO entity) {
		dao.workInsert(entity);
	}

	public void workStateChange(int widx, int wproc) {
		if(wproc <1) {
		dao.workStateChange(widx);
		dao.workStart(widx);
		}else if(wproc == 1){
			dao.workStateChange(widx);
			dao.workEnd(widx);
		}else if(wproc >= 2){
			dao.workStateChange(widx);
			dao.workBack(widx);
		}
	}
}
