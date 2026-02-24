package in.cg.resources;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Student;

@Configuration
public class JavaAppConfigFile {

    @Bean
    public Address address() {
        Address a = new Address(123,"Balaga","Srikakulam");
        
        return a;
    }

    @Bean
    public Student student() {
        Student st = new Student(101,"Pavan","pavan@gmail.com",address());

        return st;
    }
}