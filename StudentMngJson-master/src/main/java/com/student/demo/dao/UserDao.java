package com.student.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.demo.pojo.User;


@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User getUserByUsernameAndPassword(String username,String password){
		
		Session session = null;
		
		try{
			
			
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from User where username = :username and password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			User user = (User) query.uniqueResult();
			
			return user;
			
		}catch(Exception e){
			return null;
		}finally {
			session.close();
		}
		
		
		
	}

	public List<User> findAll() {
		Session session = null;
		
		try{
			
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from User");
			
			return query.list();
			
		}catch(Exception e){
			return null;
		}finally {
			session.close();
		}
	}
	
	public void delete(Integer id){
		Session session = null;
		
		try{
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			User user = (User) session.get(User.class, id);
			
			session.delete(user);
			
			session.getTransaction().commit();
		}catch(Exception e){
			if(session.getTransaction() != null){
				session.getTransaction().rollback();
			}
		}finally {
			session.close();
		}	
		
	}

	public void save(User user) {
		Session session = null;
		
		try{
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
		}catch(Exception e){
			if(session.getTransaction() != null){
				session.getTransaction().rollback();
			}
		}finally {
			session.close();
		}	
		
	}

	public User findById(Integer id) {
		Session session = null;
		try{
			
			session = sessionFactory.openSession();
			
			User user = (User) session.get(User.class, id);
			
			return user;
			
		}catch(Exception e){
			return null;
		}finally {
			session.close();
		}	
		
	}

	public void update(User user) {
		Session session = null;
		
		try{
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.update(user);
			
			session.getTransaction().commit();
		}catch(Exception e){
			if(session.getTransaction() != null){
				session.getTransaction().rollback();
			}
		}finally {
			session.close();
		}	
		
	}

}
