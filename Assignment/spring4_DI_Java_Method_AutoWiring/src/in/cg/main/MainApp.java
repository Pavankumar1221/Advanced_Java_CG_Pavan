package in.cg.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.cg.beans.Student;
import in.cg.resources.JavaAppConfigFile;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(JavaAppConfigFile.class);

        Student st = context.getBean(Student.class);

        st.display();
    }
}