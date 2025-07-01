package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.Student;
@Remote
public interface StudentService
{
public String addStudent(Student student);
public List<Student> viewallstds();
public String deletestd(String sid);
public Student viewstdbyid(String sid);
public String updatestd(Student student);
public String  updatepass(Student student);
public Student checkstdlogin(String sid,String spass);
public String addStudentEvent(Student student);
}
