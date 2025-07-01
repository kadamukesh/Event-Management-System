package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentEvents_table")
public class StudentE  implements Serializable{
	
	
	@Column(name="id")
	private String seid;
	@Column(name="username" ,nullable=false,length=50)
	private String seusername;

	@Id
	@Column(name="event" ,nullable=false,length=50)
	private String srevent;

	public String getSeid() {
		return seid;
	}

	public void setSeid(String seid) {
		this.seid = seid;
	}

	public String getSeusername() {
		return seusername;
	}

	public void setSeusername(String seusername) {
		this.seusername = seusername;
	}

	public String getSrevent() {
		return srevent;
	}

	public void setSrevent(String srevent) {
		this.srevent = srevent;
	}
}
