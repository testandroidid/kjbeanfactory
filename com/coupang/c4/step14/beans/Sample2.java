package com.coupang.c4.step14.beans;

public class Sample2 {
	private static Sample2 singleton = new Sample2();

	private long count = 0;

	// 정상적인 방법으로 상속이나 인스턴스 생성이 불가하도록 생성자를 private으로 완전 제한합니다.
	private Sample2() {
	}

	public static Sample2 getInstance() {
		return singleton;
	}
	
	
	
	
}
