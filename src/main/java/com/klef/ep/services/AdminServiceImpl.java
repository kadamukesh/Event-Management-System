package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Faculty;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService
{

  @Override
  public Admin checkadminlogin(String username, String password) 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    
    // a is an alias of Admin Class
    Query qry = em.createQuery("select a from Admin a where a.username=? and a.password=?");
    qry.setParameter(1, username);
    qry.setParameter(2, password);
    
        Admin admin = null;
        
        if(qry.getResultList().size()>0)
        {
          admin = (Admin) qry.getSingleResult();
        }
    em.close();
    emf.close();
    
    return admin;
  }

	
  @Override
  public long faccount() 
  {
  	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
  	    EntityManager em = emf.createEntityManager();
  	    
  	    Query q = em.createQuery("SELECT COUNT(c) FROM Faculty c");//for count we can give anything it can work
  	    
  	    List list=q.getResultList(); //list contain count
  	    long count=(long)list.get(0);
  	    
  	return count;
  }


@Override
public long stucount() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	    EntityManager em = emf.createEntityManager();
	    
	    Query q = em.createQuery("SELECT COUNT(c) FROM Student c");//for count we can give anything it can work
	    
	    List list=q.getResultList(); //list contain count
	    long count=(long)list.get(0);
	    
	return count;
}






}