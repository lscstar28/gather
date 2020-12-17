package com.gather.entity;

public class DesignDTOR {
	private int dIdx;
	private String dName;
	public DesignDTOR() {
		super();
	}
	public DesignDTOR(int dIdx, String dName) {
		super();
		this.dIdx = dIdx;
		this.dName = dName;
	}
	public int getdIdx() {
		return dIdx;
	}
	public void setdIdx(int dIdx) {
		this.dIdx = dIdx;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	
}
