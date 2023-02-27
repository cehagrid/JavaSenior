package com.atguigu.team.service;

/**
 * 
 * @Description 表示员工的状态
 * @author llystart
 * @version
 * @date 2022年12月7日下午8:31:50
 */
//public class Status {
//	private final String NAME;
//
//	private Status(String name) {
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//	public static Status getFree() {
//		return FREE;
//	}
//	public static Status getBusy() {
//		return BUSY;
//	}
//	public static Status getVocation() {
//		return VOCATION;
//	}
//
//	@Override
//		public String toString() {
//			return NAME;
//		}
//}

public enum Status{
	FREE,BUSY,VOCATION;
}
