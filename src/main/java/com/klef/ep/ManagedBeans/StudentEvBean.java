package com.klef.ep.ManagedBeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

import com.klef.ep.models.Event;
import com.klef.ep.models.Student;
import com.klef.ep.models.StudentE;
import com.klef.ep.services.StudentEvService;
import com.klef.ep.services.StudentService;

@ManagedBean(name="sEbean",eager = true)
public class StudentEvBean {

	
	@EJB(lookup = "java:global/EPProject/StudentEvServiceImpl!com.klef.ep.services.StudentEvService")
	  StudentEvService service;
	private String seid;
	
	private String seusername;

	private String srevent;
	
	 private List<StudentE> studen;

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
	
	
	
	public String addstudentev() throws IOException

	{
	  StudentE s1=new StudentE();
	  
	  s1.setSeid(seid);
	  s1.setSeusername(seusername);
	  s1.setSrevent(srevent);
	

	  

	  service.addStudentEvent(s1);
	  
	  
	  return "studentpayment.jsf";
	}

	public List<StudentE> getStuden() {
		 return service.viewallstdevents();
	}

	public void setStuden(List<StudentE> studen) {
		this.studen = studen;
	}
}
