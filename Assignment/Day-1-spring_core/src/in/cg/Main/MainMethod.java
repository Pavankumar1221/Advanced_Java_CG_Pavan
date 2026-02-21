package in.cg.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class MainMethod {
	public static void main(String[] args) {
		
//		Location of the configuration file
		String config_loc="/in/cg/resources/applicationContext.xml";
		
		ApplicationContext context=new ClassPathXmlApplicationContext(config_loc);
		
		
//		we are just checking that this code is taking values from the applicationContext.xml file 
		Student std1 = context.getBean("StdId-1", Student.class);
		std1.display();
		
		Student std2 = context.getBean("StdId-2", Student.class);
		std2.display();
		
		
	}
}
