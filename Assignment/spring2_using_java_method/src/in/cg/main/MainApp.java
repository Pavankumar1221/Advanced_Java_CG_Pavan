package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfigFile;

public class MainApp {
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
		
//		Important point----- if in the class if there are many beans avialable then we can create the class like this we can access the bean object by id of only single bean 
//		avialable then no issue if muliplte beans use this ----.getBean("Stdid",Student.class);
//		Student s1=(Student)context.getBean(Student.class);
//		s1.display();
		
//		 We can also access indivisual Beans using bean id
		Student s2=(Student) context.getBean("Stdid");
		s2.display();
		
		System.out.println("-------------------------------------");
		
		Student s3=(Student) context.getBean("stdid2");
		s3.display();
	}
}
