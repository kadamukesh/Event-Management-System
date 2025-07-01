package com.klef.ep.ManagedBeans;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.Student;
import com.klef.ep.services.StudentService;




@ManagedBean(name="sbean",eager = true)
public class StudentBean
{

  @EJB(lookup = "java:global/EPProject/StudentServiceImpl!com.klef.ep.services.StudentService")
  StudentService service;
  private String susername;
  private String sid;
  
  private String sgender;
  private String semail;
  private String scontact;
  private String sdepartment;
  private String spass;


  
  private List<Student> stdlist; 
  private Part imageFile;
  
  
  public Part getImageFile() {
	return imageFile;
}
public void setImageFile(Part imageFile) {
	this.imageFile = imageFile;
}
public String getSusername() {
    return susername;
  }
  public void setSusername(String susername) {
    this.susername = susername;
  }
  public String getSid() {
    return sid;
  }
  public void setSid(String sid) {
    this.sid = sid;
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
  
  public String add() throws IOException

  {
    Student s=new Student();
    s.setSid(sid);
    s.setSusername(susername);
    s.setSemail(semail);
    s.setSdepartment(sdepartment);
    s.setSgender(sgender);
    s.setScontact(scontact);
    s.setSpass(spass);
    
	if(imageFile!=null)
	{
		InputStream inputStream=imageFile.getInputStream();
		byte[] imageBytes=new byte[(int) imageFile.getSize()];
		inputStream.read(imageBytes);
		s.setImage(imageBytes);
	}
    service.addStudent(s);
    
    
    return "view1.jsf?faces-redirect=true";
  }
public List<Student> getStdlist() {
	return service.viewallstds();
}
public void setStdlist(List<Student> stdlist) {
	this.stdlist = stdlist;
}

public String update()
{//checking if id is there or not
	Student std=service.viewstdbyid(sid);
	if(std!=null)
	{
		Student s=new Student();
		s.setSid(sid);
		s.setSusername(susername);
		s.setSdepartment(sdepartment);
		s.setScontact(scontact);
		s.setSpass(spass);
		
		
	
		service.updatestd(s);
		return "supdate.jsf?faces-redirect=true";
	
	

	}
	else
	{
		return "updatefail.jsp";
//		System.out.println("not found");
	}

	

}
public String delete(String sid)
{
	service.deletestd(sid);
	//to get in the same page
	return "view1.jsf?faces-redirect=true";
}

public void changepass() throws IOException
{//checking if id is there or not
	  FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	Student std=service.viewstdbyid(sid);
	if(std!=null)
	{
		Student s=new Student();
		s.setSid(sid);
		s.setSpass(spass);
		
		
	
		service.updatepass(s);
		
		response.sendRedirect("studentlogin.jsf");
		
	
	

	}
	else
	{
		
		response.sendRedirect("changepassfail.jsp");
//		System.out.println("not found");
	}

	

	


	

}

public void validatestdlogin() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();

    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

    Student student = service.checkstdlogin(sid, spass);

    if (student != null) {
      HttpSession session = request.getSession();
      session.setAttribute("student", student);

      // Ensure the bean is set in the session scope
      session.setAttribute("sbean", this);

      response.sendRedirect("stdhome0.jsp");
    } else {
      response.sendRedirect("stdloginfail.jsf");
    }
  }



}