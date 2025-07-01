package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Certficate;
import com.klef.ep.models.Faculty;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CertificateServiceImpl implements CertificateService {

	@Override
	public String addCertificate(Certficate certficate) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		    EntityManager em = emf.createEntityManager();
		   em.getTransaction().begin();
		    em.persist(certficate);
		    em.getTransaction().commit();
		
		    em.close();
		    emf.close();
		return "Certificate added Successfully";
	}

	@Override
	public Certficate viewcerbyid(int studentId) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	        EntityManager em = emf.createEntityManager();
	        Certficate   c = em.find(Certficate.class, studentId);
	        em.close();
	        emf.close();
	        return c;
	}

	@Override
	public List<Certficate> viewallcert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select c from Certficate c");
	
		List<Certficate> clist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return clist;
	}

}
