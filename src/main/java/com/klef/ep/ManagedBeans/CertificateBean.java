package com.klef.ep.ManagedBeans;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import com.klef.ep.models.Certficate;
import com.klef.ep.models.Faculty;
import com.klef.ep.services.CertificateService;

@ManagedBean(name="cbean",eager=true)
public class CertificateBean {
	@EJB(lookup = "java:global/EPProject/CertificateServiceImpl!com.klef.ep.services.CertificateService")
	CertificateService service;
	
	private int studentId;
	 private String studentName; 
	 private String eventName;
	 private String certificateNumber;
	 private Part imageFile;
	 private List<Certficate> clist;
	
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
	public Part getImageFile() {
		return imageFile;
	}
	public void setImageFile(Part imageFile) {
		this.imageFile = imageFile;
	}
	public List<Certficate> getClist() {
		return service.viewallcert();
	}
	public void setClist(List<Certficate> clist) {
		this.clist = clist;
	}
	
	
	public String add() throws IOException

	{
		Certficate c=new Certficate();
		c.setStudentId(studentId);
		c.setStudentName(studentName);
		c.setEventName(eventName);
		c.setCertificateNumber(certificateNumber);
		if(imageFile!=null)
		{
			InputStream inputStream=imageFile.getInputStream();
			byte[] imageBytes=new byte[(int) imageFile.getSize()];
			inputStream.read(imageBytes);
			c.setImage(imageBytes);
		}
		
		service.addCertificate(c);

		return ".jsf?faces-redirect=true";
	}
	

}
