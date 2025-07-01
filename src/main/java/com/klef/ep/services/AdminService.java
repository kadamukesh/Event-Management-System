package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;




@Remote
public interface AdminService 
{
  public Admin checkadminlogin(String username,String password);
  public long faccount();
  public long stucount();
  
 
  


  
}