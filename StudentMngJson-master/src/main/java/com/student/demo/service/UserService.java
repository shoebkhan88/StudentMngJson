package com.student.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.dao.UserDao;
import com.student.demo.dto.UserDto;
import com.student.demo.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	/*public void deleteUserById(Integer id){
		
		userDao.delete(id);
		
		
		
	}*/


	/*public void saveUser(User user) {
		
		userDao.save(user);
	}*/


	public UserDto getUserByUserId(Integer id) {
		User user = userDao.findById(id);
		
		if(user != null){
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			return userDto;
		}else{
			return null;
		}
		
		
		
		
	}


	/*public void updareUser(User user) {
		userDao.update(user);
		
	}*/
	
	

}
