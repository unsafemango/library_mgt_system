package com.project.oj.borrower;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BorrowerController {
	@Autowired
	BorrowerDao borrowerDao;
	
	/**
	 * Resource to display list of borrowers
	 * */
	@RequestMapping("/viewborrower")
	public ModelAndView showBorrower() {
		List<Borrower> listBorrower= borrowerDao.getBorrowers();
	    ModelAndView mav = new ModelAndView("viewborrower");
	    mav.addObject("list", listBorrower);
	    return mav;
	}
	
	/**
	 * Resource to display form to add borrower information
	 * 'command' is a reserved request attribute which is used to display
	 * object data into form
	 * */
	@RequestMapping("/borrowerform")
	public String showForm(Model m) {
		m.addAttribute("command", new Borrower());
		return "borrowerform";
	}
	
	/**
	 * Resource to save object into the database
	 * ModelAttribute puts request data into model object
	 * */
	@RequestMapping(value="/saveborrower", method=RequestMethod.POST)
	public String save(@ModelAttribute("borrow")Borrower borrower) {
		borrowerDao.save(borrower);
		return "redirect:/viewborrower";
	}
	
	/*
	 * Resource to display data for editing
	 * PathVariablt puts URL data into variable
	 */
	@RequestMapping(value = "/editborrower/{id}")
	public String edit(@PathVariable Long id, Model m) {
		Borrower borrower = borrowerDao.getBorrowerById(id);
		m.addAttribute("command", borrower);
		return "borrowereditform";
	}
	
	/*
	 * Resource to edit model object
	 */
//	@RequestMapping(value = "/editsaveborrower", method = RequestMethod.POST)
//	public String edit(@ModelAttribute("borrow")Borrower borrower) {
//		borrowerDao.update(borrower);
//		return "redirect:viewborrower";
//	}
	
	
	/*
	 * Resource to delete record for the given id in the url
	 */
	@RequestMapping(value = "/deleteborrower/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id) {
		borrowerDao.delete(id);
		return "redirect:/viewborrower";
	}
	
}
