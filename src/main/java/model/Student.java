package model;

import java.time.LocalDate;

public class Student extends Person{
    private boolean hasPreviousJavaKnoledge;

    public Student(){

    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnoledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnoledge = hasPreviousJavaKnoledge;
    }

    public boolean isHasPreviousJavaKnoledge() {
        return hasPreviousJavaKnoledge;
    }

    public void setHasPreviousJavaKnoledge(boolean hasPreviousJavaKnoledge) {
        this.hasPreviousJavaKnoledge = hasPreviousJavaKnoledge;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString()+
                "hasPreviousJavaKnoledge=" + hasPreviousJavaKnoledge +
                '}';
    }
}
