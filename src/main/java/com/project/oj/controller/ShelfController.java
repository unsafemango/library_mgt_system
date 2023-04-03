package com.project.oj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.oj.beans.Shelf;
import com.project.oj.dao.ShelfDao;

@Controller
public class ShelfController {
	@Autowired
	ShelfDao shelfDao;
	
	/**
	 * Resource to display form to add book information
	 * 'command' is a reserved request attribute which is used to display
	 * object data into form
	 * */
	@RequestMapping("/shelfform")
	public String showForm(Model m) {
		m.addAttribute("command", new Shelf());
		return "shelfform";
	}
}
