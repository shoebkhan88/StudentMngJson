package com.student.demo.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.demo.dto.UserDto;
import com.student.demo.service.UserService;

@Controller
public class JsonController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping(value="dologin.html",method=RequestMethod.GET)
	@ResponseBody
	public Boolean isValidUser(Model model,
			@RequestParam("username") Integer username,
			@RequestParam("password")String password){
		
		return true;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="getUserByUserId.html",method=RequestMethod.GET)
	@ResponseBody
	public UserDto getUserByUserId(Model model,@RequestParam("id") Integer id){
		
		UserDto userDto = userService.getUserByUserId(id);
		
		return userDto;
		
		
	}
	
	
	
	
	

}
