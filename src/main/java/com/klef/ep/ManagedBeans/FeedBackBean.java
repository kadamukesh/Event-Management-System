package com.klef.ep.ManagedBeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.klef.ep.models.feedback;
import com.klef.ep.services.Feedback;



@ManagedBean(name="feedbean",eager=true)
public class FeedBackBean {
	
	@EJB(lookup = "java:global/EPProject/FeedbackImpl!com.klef.ep.services.Feedback")
	Feedback service;
	  private String eventId;
	    private String studentId;
	    private String feedback;
	    private List<feedback> flist;
	    
		public String getEventId() {
			return eventId;
		}
		public void setEventId(String eventId) {
			this.eventId = eventId;
		}
		public String getStudentId() {
			return studentId;
		}
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		
		
		public String addfeed() throws IOException

		{
			feedback feed=new feedback();
			feed.setStudentId(studentId);
			feed.setEventId(eventId);
			feed.setFeedback(feedback);
			service.addfeed(feed);
			
			return "feedbackform.jsf?faces-redirect=true";
			
			
		}
		public List<feedback> getFlist() {
			return service.viewallfeed();
		}
		public void setFlist(List<feedback> flist) {
			this.flist = flist;
		}
}
