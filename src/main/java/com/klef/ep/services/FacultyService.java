package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;


import com.klef.ep.models.Faculty;
@Remote
public interface FacultyService
{

	 public String addfaculty(Faculty faculty);
	 public Faculty viewfacbyid(String fid);
	  public List<Faculty> viewallfacs();
	  public String deletefac(String fid);
	  public String updatefac(Faculty faculty);
	 
	  public String  updatepass(Faculty faculty);
	  public Faculty checkfaclogin(String fid,String fpass);
}
