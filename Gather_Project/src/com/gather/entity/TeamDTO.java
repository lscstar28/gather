package com.gather.entity;

public class TeamDTO {
	private int mIdx;
	private int tIdx;
	private String tName;
	
	public TeamDTO(int mIdx, int tIdx, String tName) {
		super();
		this.mIdx = mIdx;
		this.tIdx = tIdx;
		this.tName = tName;
	}
	public TeamDTO() {
		super();
	}
	public int getmIdx() {
		return mIdx;
	}
	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}
	public int gettIdx() {
		return tIdx;
	}
	public void settIdx(int tIdx) {
		this.tIdx = tIdx;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	
}
