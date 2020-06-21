package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Group {
    private String name;
    private Trainer trainer;
    private Set<Student> studentList = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    //to prevent from adding additional student with group.getStudentList().add(new Student);
    public Set<Student> getStudentList() {
        return Collections.unmodifiableSet(studentList);
    }

    public void setStudentList() {
        this.studentList = studentList;

    }

    public  void addStudent(Student student) throws MaximumNumberOfStudentsRaeched {
        if(studentList.size() >=5) {
            throw new MaximumNumberOfStudentsRaeched();
        } else {
            studentList.add(student);
        }
    }

    public void removeStudentsYoungerThan20(){
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(Period.between(student.getDateOfBirth(), LocalDate.now()).getYears()<20){
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", trainer=" + trainer +
                ", studentList=" + studentList +
                '}';
    }


}
