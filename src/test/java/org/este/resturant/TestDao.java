package org.este.resturant;

import static org.junit.Assert.*;

import java.util.List;

import org.este.resturant.metier.IAdminResturantMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.este.resturant.entities.*;
public class TestDao {
	ClassPathXmlApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context =new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
	@Test
	public void test() {
		try {
			IAdminResturantMetier metier = (IAdminResturantMetier) context.getBean("metier");
			} catch (Exception e) { 
				assertTrue(e.getMessage(),false);
			}
		}
	}
