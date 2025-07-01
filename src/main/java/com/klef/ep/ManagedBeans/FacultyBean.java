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

import com.klef.ep.models.Admin;
import com.klef.ep.models.Faculty;
import com.klef.ep.services.FacultyService;

@ManagedBean(name="facbean",eager=true)
public class FacultyBean
{
	@EJB(lookup = "java:global/EPProject/FacultyServiceImpl!com.klef.ep.services.FacultyService")
	FacultyService service;
	
	private String fusername;
	private String fid;
	
	private String fgender;
	private String femail;
	private String fcontact;
	private String fdepartment;
	private String fpass;
	private Part imageFile;
	public Part getImageFile() {
		return imageFile;
	}
	public void setImageFile(Part imageFile) {
		this.imageFile = imageFile;
	}
	
	private List<Faculty> faclist;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFusername() {
		return fusername;
	}
	public void setFusername(String fusername) {
		this.fusername = fusername;
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
	public String getFdepartment() {
		return fdepartment;
	}
	public void setFdepartment(String fdepartment) {
		this.fdepartment = fdepartment;
	}
	public String getFpass() {
		return fpass;
	}
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}
	public List<Faculty> getFaclist() {
		return service.viewallfacs();
	}
	public void setFaclist(List<Faculty> faclist) {
		this.faclist = faclist;
	}
	
public String add() throws IOException

{
	Faculty f=new Faculty();
	f.setFid(fid);
	f.setFusername(fusername);
	f.setFgender(fgender);
	f.setFdepartment(fdepartment);
	f.setFemail(femail);
	f.setFcontact(fcontact);
	f.setFpass(fpass);
	if(imageFile!=null)
	{
		InputStream inputStream=imageFile.getInputStream();
		byte[] imageBytes=new byte[(int) imageFile.getSize()];
		inputStream.read(imageBytes);
		f.setImage(imageBytes);
	}
	
	service.addfaculty(f);

	return "view.jsf?faces-redirect=true";
}


public String update()
{//checking if id is there or not
	Faculty fac=service.viewfacbyid(fid);
	if(fac!=null)
	{
		Faculty f=new Faculty();
		f.setFid(fid);
		f.setFusername(fusername);
		f.setFdepartment(fdepartment);
		f.setFcontact(fcontact);
		f.setFpass(fpass);
		
		
	
		service.updatefac(f);
		return "fupdate.jsf?faces-redirect=true";
	
	

	}
	else
	{
		return "updatefail.jsp";
//		System.out.println("not found");
	}

	

}

public void changepass() throws IOException
{//checking if id is there or not
	  FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	Faculty fac=service.viewfacbyid(fid);
	if(fac!=null)
	{
		Faculty f=new Faculty();
		f.setFid(fid);
		f.setFpass(fpass);
		
		
	
		service.updatepass(f);
		
		response.sendRedirect("facultylogin.jsf");
		
	
	

	}
	else
	{
		
		response.sendRedirect("changepassfail.jsp");
//		System.out.println("not found");
	}

	

	


	

}

public String delete(String fid)
{
	service.deletefac(fid);
	//to get in the same page
	return "view.jsf?faces-redirect=true";
}

public void validateafaclogin() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();

    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

    Faculty faculty = service.checkfaclogin(fid, fpass);

    if (faculty != null) {
      HttpSession session = request.getSession();
      session.setAttribute("faculty", faculty);

      // Ensure the bean is set in the session scope
      session.setAttribute("facbean", this);

      response.sendRedirect("facdash.jsp");
    } else {
      response.sendRedirect("facloginfail.jsf");
    }
  }

	
}
