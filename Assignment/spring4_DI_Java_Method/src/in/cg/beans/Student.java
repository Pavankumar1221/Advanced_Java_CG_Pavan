package in.cg.beans;


public class Student {

    private int stdId;
    private String stdName;
    private String stdEmail;
    private Address a;

    // Getter & Setter
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

    public Address getA() {
        return a;
    }

    public void setA(Address a) {
        this.a = a;
    }

    public void display() {
        System.out.println(stdId + " " + stdName + " " + stdEmail);
        a.display();
    }
}