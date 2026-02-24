package in.cg.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("12305576")
	private int stdId;
	@Value("Pavan")
	private String stdName;
	@Value("pavan@gmail.com")
	private String stdEmail;
	
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	
	public void display() {
		System.out.println(stdId+" "+stdName+" "+stdEmail);
	}
}
