package com.gather.entity;


public class WorkDTO {
	private int w_Idx;			//업무번호
	private String work;		//업무타이틀
	private int w_Proc;			//업무 진행도
	private String w_SDate;		//업무 시작 날짜
	private String w_EDate;		//업무 완료 날짜
	private String w_Mem;		//담당자
	private int t_idx;			//팀번호
	
	public WorkDTO() {
		super();
	}

	public WorkDTO(int w_Idx, String work, int w_Proc, String w_SDate, String w_EDate, String w_Mem, int t_idx) {
		super();
		this.w_Idx = w_Idx;
		this.work = work;
		this.w_Proc = w_Proc;
		this.w_SDate = w_SDate;
		this.w_EDate = w_EDate;
		this.w_Mem = w_Mem;
		this.t_idx = t_idx;
	}

	public int getW_Idx() {
		return w_Idx;
	}

	public void setW_Idx(int w_Idx) {
		this.w_Idx = w_Idx;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public int getW_Proc() {
		return w_Proc;
	}

	public void setW_Proc(int w_Proc) {
		this.w_Proc = w_Proc;
	}

	public String getW_SDate() {
		return w_SDate;
	}

	public void setW_SDate(String w_SDate) {
		this.w_SDate = w_SDate;
	}

	public String getW_EDate() {
		return w_EDate;
	}

	public void setW_EDate(String w_EDate) {
		this.w_EDate = w_EDate;
	}

	public String getW_Mem() {
		return w_Mem;
	}

	public void setW_Mem(String w_Mem) {
		this.w_Mem = w_Mem;
	}

	public int getT_idx() {
		return t_idx;
	}

	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}

}