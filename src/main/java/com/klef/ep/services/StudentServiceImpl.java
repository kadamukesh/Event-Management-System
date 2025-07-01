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
import com.klef.ep.models.Student;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentServiceImpl implements StudentService
{

	@Override
	public String addStudent(Student student) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(student);
	        em.getTransaction().commit();
	        em.close();
	        emf.close();
	    return "Student added Successfully";
	}

	@Override
	public List<Student> viewallstds() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Query qry = em.createQuery("select s from Student s");
		// e is an alias of Employee Class
		List<Student> stdlist = qry.getResultList();
		
	    em.close();
	    emf.close();
	    
	    return stdlist;
	}

	@Override
	public String deletestd(String sid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");//connect to db
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Student s = em.find(Student.class, sid);
		em.remove(s);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Student Deleted Successfully";
	}

	@Override
	public Student viewstdbyid(String sid) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	        EntityManager em = emf.createEntityManager();
	        Student s = em.find(Student.class, sid);
	        em.close();
	        emf.close();
	        return s;
	}

	@Override
	public String updatestd(Student student) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Student f = em.find(Student.class, student.getSid());
		f.setSusername(student.getSusername());
		f.setSdepartment(student.getSdepartment());
		f.setScontact(student.getScontact());
		f.setSpass(student.getSpass());
	
		
	
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Student Updated Successfully";
	}

	@Override
	public Student checkstdlogin(String sid, String spass) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		    EntityManager em = emf.createEntityManager();
		    
		    
		    Query qry = em.createQuery("select s from Student s where s.sid=? and s.spass=?");
		    qry.setParameter(1, sid);
		    qry.setParameter(2, spass);
		    
		        Student student = null;
		        
		        if(qry.getResultList().size()>0)
		        {
		          student = (Student) qry.getSingleResult();
		        }
		    em.close();
		    emf.close();
		    
		    return student;
	}

	@Override
	public String updatepass(Student student) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Student s = em.find(Student.class, student.getSid());

		s.setSpass(student.getSpass());
	
		
	
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Pass Updated Successfully";
	}

	@Override
	public String addStudentEvent(Student student) {


		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	     EntityManager em = emf.createEntityManager();
	     em.getTransaction().begin();
	     em.persist(student);
	     em.getTransaction().commit();
	     em.close();
	     emf.close();
	 return "Studentevent added Successfully";
	}

	

}
