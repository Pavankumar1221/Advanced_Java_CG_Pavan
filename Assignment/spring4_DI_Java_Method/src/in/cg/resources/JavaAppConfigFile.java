package in.cg.resources;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

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
    public Student student() {
        Student st = new Student();
        st.setStdId(1002);
        st.setStdName("Pavan Kumar");
        st.setStdEmail("pavan@gmail.com");
        
        // we are injecting the Address object to the Student class
        st.setA(address());

        return st;
    }
}