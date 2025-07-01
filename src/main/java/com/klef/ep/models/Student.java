package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="student_table")
public class Student implements Serializable
{

	@Id
	@Column(name="id")
	private String sid;
	@Column(name="username" ,nullable=false,length=50)
	private String susername;
	@Column(name="gender",nullable=false,length=10)
	private String sgender;
	@Column(name="email",nullable=false,length=50,unique=true)
	private String semail;
	@Column(name="contact",nullable=false,length=20,unique=true)
	private String scontact;
	@Column(name="department",nullable=false,length=50)
	private String sdepartment;
	@Column(name="password",nullable=false,length=50)
	private String spass;
	
	
	

	@Lob
	@Column(name="student_image",nullable = false)  //Large Object (Lob)
	private byte[] image;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSusername() {
		return susername;
	}
	public void setSusername(String susername) {
		this.susername = susername;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getScontact() {
		return scontact;
	}
	public void setScontact(String scontact) {
		this.scontact = scontact;
	}
	public String getSdepartment() {
		return sdepartment;
	}
	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
