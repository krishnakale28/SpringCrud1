package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.Services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public Student saveStd(@RequestBody Student std) {
		Student std1=studentRepo.save(std);
		return std1;
	}

	@Override
	public List<Student> readStudent() {
		List<Student> list=studentRepo.findAll();
		return list;
	}

	@Override
	public String deleteByIdStd(int id) {
		studentRepo.deleteById(id);
		String s="Deleted Successfully";
		return s;
	}

	@Override
	public Student readStdById(int id) {
		Student std=studentRepo.findById(id).orElse(null);
		return std;
	}

	@Override
	public Student updateById(Student std) {
		List<Student> list=studentRepo.findAll();
		Student std1=new Student();
		for(Student data:list) {
			if(data.getId()==std.getId()) {
				data.setName(std.getName());
				data.setEmailId(std.getEmailId());
				data.setMobileNo(std.getMobileNo());
				studentRepo.save(data);
				return data;
			}
		}
		return std1;
	}
	

}
