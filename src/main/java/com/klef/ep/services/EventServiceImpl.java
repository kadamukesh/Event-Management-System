package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.*;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EventServiceImpl implements EventService
{

  @Override
  public String addEvent(Event event) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    em.getTransaction().begin();
    em.persist(event);
    em.getTransaction().commit();
    em.close();
    emf.close();

    return "Event Added Successfully";
            }

  @Override
  public List<Event> viewallevents() {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    
    Query qry=em.createQuery("select e from Event e");
    List<Event> event=qry.getResultList();

    em.close();
    emf.close();
    return event;
  }

  

  @Override
  public String deleteevent(long eid) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    em.getTransaction().begin();
    Event e=em.find(Event.class,eid);
    em.remove(e);
    em.getTransaction().commit();
    em.close();
    emf.close();
    return "Deleted Successfully";
  }

  @Override
  public Event findEventById(Long eventId) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    return em.find(Event.class ,eventId);
  }

@Override
public String updateeve(Event event) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	Event e = em.find(Event.class, event.getId());
	
	e.setName(event.getName());
	e.setPayment(event.getPayment());
	e.setVenu(event.getVenu());
	

	

	
	em.getTransaction().commit();
	em.close();
	emf.close();
	
	return "Event Updated Successfully";
}





  

}