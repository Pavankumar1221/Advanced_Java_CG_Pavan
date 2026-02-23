package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;

public class MainApp {

    public static void main(String[] args) {

        String config_loc = "in/cg/resources/SpringJavaConfigFile.xml";

        ApplicationContext context=new ClassPathXmlApplicationContext(config_loc);
        
        Student s1 = (Student) context.getBean("student");
        s1.display();
    }
}