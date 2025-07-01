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
public class FacultyServiceImpl implements FacultyService
{

	@Override
	public String addfaculty(Faculty faculty) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		    EntityManager em = emf.createEntityManager();
		   em.getTransaction().begin();
		    em.persist(faculty);
		    em.getTransaction().commit();
		
		    em.close();
		    emf.close();
		return "Faculty added Successfully";
	}

	@Override
	public Faculty viewfacbyid(String fid) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	        EntityManager em = emf.createEntityManager();
	        Faculty f = em.find(Faculty.class, fid);
	        em.close();
	        emf.close();
	        return f;
	}

	@Override
	public List<Faculty> viewallfacs() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select f from Faculty f");
		// e is an alias of Employee Class
		List<Faculty> emplist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return emplist;
	}

	@Override
	public String deletefac(String fid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");//connect to db
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Faculty f = em.find(Faculty.class, fid);
		em.remove(f);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Employee Deleted Successfully";
	}

	@Override
	public String updatefac(Faculty faculty) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Faculty f = em.find(Faculty.class, faculty.getFid());
		f.setFusername(faculty.getFusername());
		f.setFdepartment(faculty.getFdepartment());
		f.setFcontact(faculty.getFcontact());
		f.setFpass(faculty.getFpass());
	
		
	
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Employee Updated Successfully";
	}

	@Override
	public Faculty checkfaclogin(String fid, String fpass) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		    EntityManager em = emf.createEntityManager();
		    
		    
		    Query qry = em.createQuery("select f from Faculty f where f.fid=? and f.fpass=?");
		    qry.setParameter(1, fid);
		    qry.setParameter(2, fpass);
		    
		        Faculty faculty = null;
		        
		        if(qry.getResultList().size()>0)
		        {
		          faculty = (Faculty) qry.getSingleResult();
		        }
		    em.close();
		    emf.close();
		    
		    return faculty;
	}

	@Override
	public String updatepass(Faculty faculty) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Faculty f = em.find(Faculty.class, faculty.getFid());

		f.setFpass(faculty.getFpass());
	
		
	
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Pass Updated Successfully";
	}

	


}
