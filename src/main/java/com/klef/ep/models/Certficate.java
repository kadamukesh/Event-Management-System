package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="certificate_table")
public class Certficate implements Serializable
{
	@Id
	@Column(name="id")
	private int studentId;
	 @Column(name="sname",length=50,nullable = false)
    private String studentName; 
	 @Column(name="ename",length=50,nullable = false)
    private String eventName; 
	 @Column(name="cnumber",nullable = false,unique = true,length = 20)
    private String certificateNumber;
	 
	 @Lob
	 @Column(name="certificate_image",nullable = false)  //Large Object (Lob)
	 private byte[] image;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	} 
}
