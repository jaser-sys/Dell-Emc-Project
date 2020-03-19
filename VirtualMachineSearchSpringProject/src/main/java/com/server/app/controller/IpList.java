package com.server.app.controller;

import java.util.List;

public class IpList {
	private List<String> ip;
	public IpList() {
		super();
	}
	public IpList(List<String> ip) {
		super();
		this.ip = ip;
	}
	public List<String> getIp() {
		return ip;
	}
	public void setIp(List<String> ip) {
		this.ip = ip;
	}
	
}
