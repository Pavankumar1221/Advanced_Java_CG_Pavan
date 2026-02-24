package in.cg.beans;

import java.util.List;

public class Subject {

    private List<String> subjects;

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void display() {
        System.out.println("Subjects: " + subjects);
    }
}

