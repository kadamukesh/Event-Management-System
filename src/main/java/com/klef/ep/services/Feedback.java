package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.feedback;

@Remote
public interface Feedback {

	public	String addfeed(feedback feed);
	 public List<feedback> viewallfeed();

}
