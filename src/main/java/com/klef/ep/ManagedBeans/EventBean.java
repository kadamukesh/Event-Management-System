package com.klef.ep.ManagedBeans;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import com.klef.ep.models.*;
import com.klef.ep.services.*;

@ManagedBean(name = "eventbean", eager = true)
public class EventBean {
    @EJB(lookup = "java:global/EPProject/EventServiceImpl!com.klef.ep.services.EventService")
    private EventService eventservice;

    private Long id;
    private String name;
    private String description;
    private Date startDate;
   
    private Date endDate;
    private Date registrationDeadline;
    private String venu;
    private Part imageFile;
    private List<Event> event;
    private double payment;

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public List<Event> getEvent() {
        return eventservice.viewallevents();
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public String getVenu() {
        return venu;
    }

    public void setVenu(String venu) {
        this.venu = venu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public Part getImageFile() {
        return imageFile;
    }

    public void setImageFile(Part imageFile) {
        this.imageFile = imageFile;
    }

    public String addEvent() throws IOException {
        Event e = new Event();
        e.setId(id);
        e.setName(name);
        e.setDescription(description);
        e.setVenu(venu);
        e.setStartDate(startDate);
        e.setEndDate(endDate);
        e.setRegistrationDeadline(registrationDeadline);
        e.setPayment(payment);
        if (imageFile != null) {
            InputStream inputStream = imageFile.getInputStream();
            byte[] imageBytes = new byte[(int) imageFile.getSize()];
            inputStream.read(imageBytes);
            e.setImage(imageBytes);
        }

        eventservice.addEvent(e);

        return "eventview.jsf";
    }

    public String deleteevent(long eid) {
        eventservice.deleteevent(eid);
        return "eventview.jsf?faces-redirect=true";
    }

    public byte[] getEventImage(Long eventId) {
        Event event = eventservice.findEventById(eventId);
        return event.getImage();
    }
    
    
    public String eventupdate()
    {//checking if id is there or not
    	Event eve=eventservice.findEventById(id);
    	if(eve!=null)
    	{
    		Event e=new Event();
    		e.setId(id);
    		e.setName(name);
    	
    		e.setPayment(payment);
    		e.setVenu(venu);
    		
    	
    		
    	
    	eventservice.updateeve(e);
    		return "eventupdate.jsf?faces-redirect=true";
    	
    	

    	}
    	else
    	{
    		return "updatefail.jsp";
//    		System.out.println("not found");
    	}

    	

    }
  

   
}