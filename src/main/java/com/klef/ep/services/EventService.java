package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.*;

@Remote
public interface EventService 
{
  public String addEvent(Event event);
  public List<Event>viewallevents();
  public String deleteevent(long eid);
  public Event findEventById(Long eventId);
  public String updateeve(Event event);
 
  
}