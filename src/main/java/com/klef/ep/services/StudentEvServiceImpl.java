package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Event;
import com.klef.ep.models.Student;
import com.klef.ep.models.StudentE;
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentEvServiceImpl implements StudentEvService{

	@Override
	public String addStudentEvent(StudentE student1) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(student1);
	        em.getTransaction().commit();
	        em.close();
	        emf.close();
	    return "Student Event added Successfully";
	}

	@Override
	public List<StudentE> viewallstdevents() {
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		    EntityManager em=emf.createEntityManager();
		    
		    
		    Query qry=em.createQuery("select s1 from StudentE s1");
		    List<StudentE> student=qry.getResultList();

		    em.close();
		    emf.close();
		    return student;
	}

}
