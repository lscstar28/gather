package com.gather.entity;

public class DesignDTO {
	private int d_Idx; // 기획번호
	private String d_Name; // 기획주제
	private String d_Purp; // 기획목적
	private String d_Con; // 기획내용
	private int t_idx; // 팀번호

	public DesignDTO() {
		super();
	}

	public DesignDTO(int d_Idx, String d_Name, String d_Purp, String d_Con, int t_idx) {
		super();
		this.d_Idx = d_Idx;
		this.d_Name = d_Name;
		this.d_Purp = d_Purp;
		this.d_Con = d_Con;
		this.t_idx = t_idx;
	}

	public int getD_Idx() {
		return d_Idx;
	}

	public void setD_Idx(int d_Idx) {
		this.d_Idx = d_Idx;
	}

	public String getD_Name() {
		return d_Name;
	}

	public void setD_Name(String d_Name) {
		this.d_Name = d_Name;
	}

	public String getD_Purp() {
		return d_Purp;
	}

	public void setD_Purp(String d_Purp) {
		this.d_Purp = d_Purp;
	}

	public String getD_Con() {
		return d_Con;
	}

	public void setD_Con(String d_Con) {
		this.d_Con = d_Con;
	}

	public int getT_idx() {
		return t_idx;
	}

	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}

}
