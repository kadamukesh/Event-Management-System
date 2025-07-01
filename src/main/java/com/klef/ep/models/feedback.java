package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback_table")
public class feedback implements Serializable {

	@Id
    private String eventId;
    private String studentId;
    private String feedback;
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
   

    

   
}
