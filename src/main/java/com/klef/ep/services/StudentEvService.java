package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Event;
import com.klef.ep.models.Student;
import com.klef.ep.models.StudentE;
@Remote
public interface StudentEvService {

	 public String addStudentEvent(StudentE student1);
	 public List<StudentE>viewallstdevents();
}
