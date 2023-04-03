package com.project.oj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.oj.beans.Student;
import com.project.oj.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
	StudentDao studentDao;
	
	/**
	 * Resource to display form to add student information
	 * 'command' is a reserved request attribute which is used to display
	 * object data into form
	 * */
	@RequestMapping("/studentform")
	public String showForm(Model m) {
		m.addAttribute("command", new Student());
		return "studentform";
	}
	
	/**
	 * Resource to save object into the database
	 * ModelAttribute puts request data into model object
	 * */
	@RequestMapping(value="/savestudent", method=RequestMethod.POST)
	public String save(@ModelAttribute("borrow")Student student) {
		studentDao.save(student);
		return "redirect:/viewstudent";
	}
	
	/*
	 * Resource to display data for editing
	 * PathVariablt puts URL data into variable
	 */
	@RequestMapping(value = "/editstudent/{id}")
	public String edit(@PathVariable int id, Model m) {
		Student student = studentDao.getStudentById(id);
		m.addAttribute("command", student);
		return "studenteditform";
	}
	
	/*
	 * Resource to edit model object
	 */
	@RequestMapping(value = "/editsavestudent", method = RequestMethod.POST)
	public String edit(@ModelAttribute("student")Student student) {
		studentDao.update(student);
		return "redirect:viewstudent";
	}
	
	
	/*
	 * Resource to delete record for the given id in the url
	 */
	@RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id) {
		studentDao.delete(id);
		return "redirect:/viewstudent";
	}
}
