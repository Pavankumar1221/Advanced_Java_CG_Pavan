package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {
	
//	One way to create Bean object-- method name and bean name is same
	@Bean
	public Student Stdid() {
		Student s1=new Student();
		s1.setStdId(5501);
		s1.setStdEmail("pavan@gmail.com");
		s1.setStdName("Pavan Kumar");
		
		return s1;
	}
	
//	Another way for creating the bean object with method name and bean name are different
	@Bean("stdid2")
	public Student createStudentObject() {
		Student s1=new Student();
		s1.setStdId(5502);
		s1.setStdEmail("cbum@gmail.com");
		s1.setStdName("Cbum");
		
		return s1;
	}
	
	
	
	
	
}
