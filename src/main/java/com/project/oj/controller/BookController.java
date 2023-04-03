package com.project.oj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.oj.beans.Book;
import com.project.oj.dao.BookDao;

@Controller
public class BookController {
	@Autowired
	BookDao bookDao;
	
	/**
	 * Resource to display form to add book information
	 * 'command' is a reserved request attribute which is used to display
	 * object data into form
	 * */
	@RequestMapping("/bookform")
	public String showForm(Model m) {
		m.addAttribute("command", new Book());
		return "bookform";
	}
	
	/**
	 * Resource to save object into the database
	 * ModelAttribute puts request data into model object
	 * */
	@RequestMapping(value="/savebook", method=RequestMethod.POST)
	public String save(@ModelAttribute("staff")Book book) {
		bookDao.save(book);
		return "redirect:/viewbook";
	}
	
	/*
	 * Resource to display data for editing
	 * PathVariablt puts URL data into variable
	 */
	@RequestMapping(value = "/editbook/{id}")
	public String edit(@PathVariable int id, Model m) {
		Book book = bookDao.getBookById(id);
		m.addAttribute("command", book);
		return "bookeditform";
	}
	
	/*
	 * Resource to edit model object
	 */
	@RequestMapping(value = "/editsavebook", method = RequestMethod.POST)
	public String edit(@ModelAttribute("book")Book book) {
		bookDao.update(book);
		return "redirect:viewbook";
	}
	
	
	/*
	 * Resource to delete record for the given id in the url
	 */
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id) {
		bookDao.delete(id);
		return "redirect:/viewbook";
	}
	
}
