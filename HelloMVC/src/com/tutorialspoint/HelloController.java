package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Dao.EmpDao;
import model.Employee;
import model.Location;

import org.springframework.ui.ModelMap;

@Controller

public class HelloController 
{
	String status="";
	EmpDao dao;
   public EmpDao getDao() {
		return dao;
	}

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

@RequestMapping(value="/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
   
   @RequestMapping(value="/student",method=RequestMethod.GET)
   public ModelAndView student()
   {
	   return new ModelAndView("student","command",new Student());
	   
   }
   @RequestMapping(value="/addStudent",method=RequestMethod.GET)
   public String addStudent(@ModelAttribute("SpringWeb")Student student,ModelMap model)
   {
	   model.addAttribute("name", student.getName());
	   model.addAttribute("age", student.getAge());
	   model.addAttribute("id", student.getId());
	   return "result";
   }
    
   @RequestMapping(value="/addEmp",method=RequestMethod.GET)
   public String addEmp(@ModelAttribute("addEmp")Employee emp,ModelMap model)
   {
	   model.addAttribute("name",emp.getName());
	   model.addAttribute("location",emp.getLocation());
	   //int i=dao.save(emp);
	   //System.out.println(i);
	   return "EmpAdded";
   }
   @RequestMapping(value="getAvail",method=RequestMethod.GET)
   public String getAvail(@ModelAttribute("getAvail")Location l)
   {
	   ModelMap model=new ModelMap();
	   String transferlocation=l.getLocation();
	   status=dao.getAvailability(transferlocation);
	   model.addAttribute("status",status);
	   return "availability";
   }
   @RequestMapping(value="updateLocation",method=RequestMethod.GET)
   public String updateLocation(@PathVariable String location)
   {
	   
	   
	   if(status.equals("Y"))
	   {
		   
	   }
	   else
	   {
		   
	   }
	   return "";
   }
   
}
