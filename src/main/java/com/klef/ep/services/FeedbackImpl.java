package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.feedback;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FeedbackImpl  implements Feedback{

	@Override
	public String addfeed(feedback feed) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		    EntityManager em = emf.createEntityManager();
		   em.getTransaction().begin();
		    em.persist(feed);
		    em.getTransaction().commit();
		
		    em.close();
		    emf.close();
		return "feedback added Successfully";
		
	}

	@Override
	public List<feedback> viewallfeed() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select z from feedback z");
		// e is an alias of Employee Class
		List<feedback> flist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return flist;
	}

}
