package com.gather.entity;

public class WorkDTOR {
	private int wIdx;
	private String work;
	private int wProc;
	private String wSDate;
	private String wEDate;
	private String wMem;
	private int tidx;
	public WorkDTOR() {
		super();
	}
	public WorkDTOR(int wIdx, String work, int wProc, String wSDate, String wEDate, String wMem, int tidx) {
		super();
		this.wIdx = wIdx;
		this.work = work;
		this.wProc = wProc;
		this.wSDate = wSDate;
		this.wEDate = wEDate;
		this.wMem = wMem;
		this.tidx = tidx;
	}
	public int getwIdx() {
		return wIdx;
	}
	public void setwIdx(int wIdx) {
		this.wIdx = wIdx;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public int getwProc() {
		return wProc;
	}
	public void setwProc(int wProc) {
		this.wProc = wProc;
	}
	public String getwSDate() {
		return wSDate;
	}
	public void setwSDate(String wSDate) {
		this.wSDate = wSDate;
	}
	public String getwEDate() {
		return wEDate;
	}
	public void setwEDate(String wEDate) {
		this.wEDate = wEDate;
	}
	public String getwMem() {
		return wMem;
	}
	public void setwMem(String wMem) {
		this.wMem = wMem;
	}
	public int getTidx() {
		return tidx;
	}
	public void setTidx(int tidx) {
		this.tidx = tidx;
	}
	
	
}
