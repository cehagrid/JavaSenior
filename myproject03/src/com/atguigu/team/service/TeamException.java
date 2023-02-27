package com.atguigu.team.service;

/**
 * 
 * @Description 自定义异常类
 * @author llystart
 * @version
 * @date 2022年12月8日上午11:22:26
 */
public class TeamException extends Exception {
	static final long serialVersionUID = -338793124229948L;

	public TeamException() {
		super();
	}

	public TeamException(String msg) {
		super(msg);
	}

}
