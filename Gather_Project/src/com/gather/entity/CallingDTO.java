package com.gather.entity;

public class CallingDTO {
	private int tIdx;
	private String mId;
	public CallingDTO() {
		super();
	}
	public CallingDTO(int tIdx, String mId) {
		super();
		this.tIdx = tIdx;
		this.mId = mId;
	}
	public int gettIdx() {
		return tIdx;
	}
	public void settIdx(int tIdx) {
		this.tIdx = tIdx;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	
	
}
