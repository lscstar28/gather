package com.gather.entity;


public class ConferenceDTO {
	private int c_Idx;			//회의번호
	private String c_title;		//회의 제목
	private String c_content;	//회의 내용
	private String c_date;		//회의 작성 날짜
	private int t_idx;			//팀번호
	
	public ConferenceDTO() {
		super();
	}

	public ConferenceDTO(int c_Idx, String c_title, String c_content, String c_date, int t_idx) {
		super();
		this.c_Idx = c_Idx;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_date = c_date;
		this.t_idx = t_idx;
	}

	public int getC_Idx() {
		return c_Idx;
	}

	public void setC_Idx(int c_Idx) {
		this.c_Idx = c_Idx;
	}

	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public int getT_idx() {
		return t_idx;
	}

	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}
	
}