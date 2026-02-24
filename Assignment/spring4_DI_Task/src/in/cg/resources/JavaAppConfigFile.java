package in.cg.resources;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import in.cg.beans.Address;
import in.cg.beans.Student;
import in.cg.beans.Subject;

@Configuration
public class JavaAppConfigFile {

    @Bean
    public Address address() {
        Address a = new Address();
        a.setHouseNo(83);
        a.setStreetName("Balaga Street");
        a.setCityName("Srikakulam");
        return a;
    }

    @Bean
    public Subject subject() {
        Subject s = new Subject();
        s.setSubjects(Arrays.asList("JAVA", "C++", "HTML", "English"));
        return s;
    }

    @Bean
    public Student student() {
        Student st = new Student();
        st.setStdId(1002);
        st.setStdName("Pavan Kumar");
        st.setStdEmail("pavan@gmail.com");
        return st;
    }
}