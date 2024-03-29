package com.iot1.sql.db.dto;

import org.springframework.stereotype.Component;

@Component
public class DbInfo {
	
	private int diNum; 
	private int uiNum; 
	private String dbTitle;
	private String dbUrl;
	private String dbms;
	private String id;
	private String pwd;
	private String port;
	private String driverName;
	
	public int getDiNum() {
		return diNum;
	}
	public void setDiNum(int diNum) {
		this.diNum = diNum;
	}
	public int getUiNum() {
		return uiNum;
	}
	public void setUiNum(int uiNum) {
		this.uiNum = uiNum;
	}
	public String getDbTitle() {
		return dbTitle;
	}
	public void setDbTitle(String dbTitle) {
		this.dbTitle = dbTitle;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbms() {
		return dbms;
	}
	public void setDbms(String dbms) {
		this.dbms = dbms;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	@Override
	public String toString() {
		return "Dbinfo [diNum=" + diNum + ", uiNum=" + uiNum + ", dbTitle=" + dbTitle + ", dbUrl=" + dbUrl + ", dbms="
				+ dbms + ", id=" + id + ", pwd=" + pwd + ", port=" + port + ", driverName=" + driverName + "]";
	}

}
