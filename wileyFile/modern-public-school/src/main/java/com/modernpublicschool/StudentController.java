package com.modernpublicschool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView displayStudentForm() {
		return new ModelAndView("student", "command", new Student());
	}
	
	@RequestMapping(value="/addStudent", method=RequestMethod.POST)
	public String displayStudent(@ModelAttribute("SpringWeb")Student student,ModelMap model) {
		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		
		return "display";
	}
}
