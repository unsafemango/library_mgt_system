package com.project.oj.shelf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ShelfController {
	@Autowired
	ShelfDao shelfDao;
	
	/**
	 * Resource to display list of shelves
	 * */
	@RequestMapping("/viewshelf")
	public ModelAndView showShelf() {
		List<Shelf> listShelf = shelfDao.getShelves();
	    ModelAndView mav = new ModelAndView("viewshelf");
	    mav.addObject("list", listShelf);
	    return mav;
	}
	
	
}
