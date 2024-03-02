package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Student;

public interface StudentService {
	
	public Student saveStd(Student std);
	public List<Student> readStudent();
	public String deleteByIdStd(int id);
	public Student readStdById(int id);
	public Student updateById(Student std);
	

}
