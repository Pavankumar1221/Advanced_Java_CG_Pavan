package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class MainApp {
	public static void main(String[] args) {
		String config_loc="in/cg/resources/ApplicationContext.xml";
		ApplicationContext context=new ClassPathXmlApplicationContext(config_loc);
		
		Student st=(Student) context.getBean("StdId-1");
		st.display();
	}
}	
