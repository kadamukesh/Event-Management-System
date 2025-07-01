package com.klef.ep.ManagedBeans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Admin;
import com.klef.ep.services.AdminService;

@ManagedBean(name="adminbean", eager=true)
public class AdminBean {

  @EJB(lookup = "java:global/EPProject/AdminServiceImpl!com.klef.ep.services.AdminService")
  AdminService adminService;

  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void validateadminlogin() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();

    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

    Admin admin = adminService.checkadminlogin(username, password);

    if (admin != null) {
      HttpSession session = request.getSession();
      session.setAttribute("admin", admin);

      // Ensure the bean is set in the session scope
      session.setAttribute("adminbean", this);

      response.sendRedirect("adminhome0.jsp");
    } else {
      response.sendRedirect("adminloginfail.jsf");
    }
  }

  public long getFaccount() {
    return adminService.faccount();
  }
  
  public long getStucount() {
	    return adminService.stucount();
	}

  @Override
  public String toString() {
    return "AdminBean [username=" + username + ", password=" + password + "]";
  }
}
