package com.springcourse;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.springcourse.dao.AdminDao;
import com.springcourse.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
			
		try {			

			Admin admin = adminDao.finById(1);
			System.out.println("Admin con id " + admin.getIdAd());
			
			admin.setCargo("subgerente");
			admin.setNombre("Leidy Ballesteros");
			
			if (adminDao.update(admin)) {
				System.out.println("Actualizado correctamente : " + admin);
			}
			
			/**
			if (adminDao.delete(admin.getIdAd())) {
				System.out.println("Admin: " + admin.getNombre() + "eliminado correctamente");
			}
			**/
			
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();		
		}
		
		
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		
	}
	
}
