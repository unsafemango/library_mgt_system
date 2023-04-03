package com.project.oj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.oj.beans.Staff;
import com.project.oj.dao.StaffDao;

@Controller
public class StaffController {
	StaffDao staffDao;
	/**
	 * Resource to display form to add staff information
	 * 'command' is a reserved request attribute which is used to display
	 * object data into form
	 * */
	@RequestMapping("/staffform")
	public String showForm(Model m) {
		m.addAttribute("command", new Staff());
		return "staffform";
	}
	
	/**
	 * Resource to save object into the database
	 * ModelAttribute puts request data into model object
	 * */
	@RequestMapping(value="/savestaff", method=RequestMethod.POST)
	public String save(@ModelAttribute("staff")Staff staff) {
		staffDao.save(staff);
		return "redirect:/viewstaff";
	}
	
	/*
	 * Resource to display data for editing
	 * PathVariablt puts URL data into variable
	 */
	@RequestMapping(value = "/editstaff/{id}")
	public String edit(@PathVariable int id, Model m) {
		Staff staff = staffDao.getStaffById(id);
		m.addAttribute("command", staff);
		return "staffeditform";
	}
	
	/*
	 * Resource to edit model object
	 */
	@RequestMapping(value = "/editsavestaff", method = RequestMethod.POST)
	public String edit(@ModelAttribute("staff")Staff staff) {
		staffDao.update(staff);
		return "redirect:viewstaff";
	}
	
	
	/*
	 * Resource to delete record for the given id in the url
	 */
	@RequestMapping(value = "/deletestaff/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id) {
		staffDao.delete(id);
		return "redirect:/viewstaff";
	}
}
