package main;

import model.Student;
import services.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService.displayAllGroups();
        StudentService.displayStudentsAlphabetically();
        StudentService.displayGroupWithMaxStudents();
        StudentService.displayStudentsYoungerThan25();
        StudentService.displayStudentsWithJavaKnowledge();
        StudentService.displayStudentsByTrainer();

    }
}
