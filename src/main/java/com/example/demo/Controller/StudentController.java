package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.Services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("save/")
	public Student saveStd(@RequestBody Student std) {
		studentService.saveStd(std);
		return std;
	}
	
	@GetMapping("read/")
	public List<Student> readData(){
		List<Student> list=studentService.readStudent();
		return list;
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteById(@PathVariable int id) {
		String s=studentService.deleteByIdStd(id);
		return s;
	}
	
	@GetMapping("readById/{id}")
	public Student readStdById(@PathVariable int id) {
		Student std=studentService.readStdById(id);
		return std;	
	}
	
	@PutMapping("update/")
	public Student updataById(@RequestBody Student std) {
		Student std1=studentService.updateById(std);
		return std1;
	}

}
