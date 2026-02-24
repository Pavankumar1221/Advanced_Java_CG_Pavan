package in.cg.beans;


public class Student {

    private int stdId;
    private String stdName;
    private String stdEmail;
    private Address a;

    public Student(int stdId, String stdName, String stdEmail, Address a) {
    	this.stdId=stdId;
    	this.stdName=stdName;
    	this.stdEmail=stdEmail;
    	this.a=a;
    }

    public void display() {
        System.out.println(stdId + " " + stdName + " " + stdEmail);
        a.display();
    }
}