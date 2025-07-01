package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="faculty_table")
public class Faculty implements Serializable
{
@Id
@Column(name="id")
private String fid;
@Column(name="username" ,nullable=false,length=50)
private String fusername;
@Column(name="gender",nullable=false,length=10)
private String fgender;
@Column(name="email",nullable=false,length=50,unique=true)
private String femail;
@Column(name="contact",nullable=false,length=20,unique=true)
private String fcontact;
@Column(name="department",nullable=false,length=50)
private String fdepartment;
@Column(name="password",nullable=false,length=50)
private String fpass;

@Lob
@Column(name="faculty_image",nullable = false)  //Large Object (Lob)
private byte[] image;

public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}


public String getFusername() {
	return fusername;
}
public void setFusername(String fusername) {
	this.fusername = fusername;
}
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public String getFgender() {
	return fgender;
}
public void setFgender(String fgender) {
	this.fgender = fgender;
}
public String getFemail() {
	return femail;
}
public void setFemail(String femail) {
	this.femail = femail;
}
public String getFcontact() {
	return fcontact;
}
public void setFcontact(String fcontact) {
	this.fcontact = fcontact;
}
public String getFpass() {
	return fpass;
}
public void setFpass(String fpass) {
	this.fpass = fpass;
}
public String getFdepartment() {
	return fdepartment;
}
public void setFdepartment(String fdepartment) {
	this.fdepartment = fdepartment;
}



}
