package edu.mvctest;

import java.sql.Date;

public class Student {
	//DO 임
	private int  id ; //sql의 필드명하고 이름이 같아야 나중 스프링에서 자동으로 생성됌
	private String username ;
	private String univ ;
	private Date birth;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId( int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
