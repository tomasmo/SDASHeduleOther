package repositories;

import model.Group;
import model.MaximumNumberOfStudentsRaeched;
import model.Student;
import model.Trainer;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//to store all courses, students, trainers
public class CentralRepository {

    private final static int NUMBER_OF_STUDENTS = 15;//final nerasom jei planuojam priskirti kita reiksme veliau
    private final static int NUMBER_OF_TRAINERS = 3;//final nerasom jei planuojam priskirti kita reiksme veliau
    private final static int NUMBER_OF_GROUPS = 4;//final nerasom jei planuojam priskirti kita reiksme veliau


    private static List<Student> studentList = new ArrayList<>();
    private static List<Trainer> trainerList = new ArrayList<>();
    private static List<Group> groupList = new ArrayList<>();

    //static block to initialize list elements

    static {
        for (int i = 1; i <= NUMBER_OF_STUDENTS; i++) {
            Student student = new Student();
            student.setFirstName(RandomStringUtils.random(5, true, false).toLowerCase());
            student.setLastName(RandomStringUtils.random(5, true, false).toLowerCase());
            student.setDateOfBirth(generateRandomDate(1980, 2000));
            student.setHasPreviousJavaKnoledge(new Random().nextBoolean());
            studentList.add(student);
        }
        //trainers generator
        for (int i = 1; i <= NUMBER_OF_TRAINERS; i++) {
            Trainer trainer = new Trainer();
            trainer.setFirstName(RandomStringUtils.random(5, true, false).toLowerCase());
            trainer.setLastName(RandomStringUtils.random(5, true, false).toLowerCase());
            trainer.setDateOfBirth(generateRandomDate(1970, 1900));
            trainer.setAutorised(new Random().nextBoolean());
            trainerList.add(trainer);
        }
        //groups generator
        for (int i = 1  ; i <= NUMBER_OF_GROUPS; i++) {
            Group group = new Group();
            group.setName("Group_" + i);

            //asign random trainer to the group. no cprruption
            Trainer trainer = trainerList.get(getRandomIntBetween(0,2));
            group.setTrainer(trainer);
            groupList.add(group);
        }

        try {
            groupList.get(0).addStudent(studentList.get(0));
            groupList.get(0).addStudent(studentList.get(1));
            groupList.get(0).addStudent(studentList.get(2));

            groupList.get(1).addStudent(studentList.get(3));
            groupList.get(1).addStudent(studentList.get(4));
            groupList.get(1).addStudent(studentList.get(5));

            groupList.get(2).addStudent(studentList.get(6));
            groupList.get(2).addStudent(studentList.get(7));
            groupList.get(2).addStudent(studentList.get(8));

            groupList.get(3).addStudent(studentList.get(9));
            groupList.get(3).addStudent(studentList.get(10));
            groupList.get(3).addStudent(studentList.get(11));
            groupList.get(3).addStudent(studentList.get(12));




        } catch (MaximumNumberOfStudentsRaeched maximumNumberOfStudentsRaeched) {
            maximumNumberOfStudentsRaeched.printStackTrace();
        }
    }
    private static int getRandomIntBetween(int start, int end) {
        return (int) (start + Math.round(Math.random() * (end - start)));
    }
    private static LocalDate generateRandomDate(int startYear, int endYear) {
        int day = getRandomIntBetween(1,28);
        int month = getRandomIntBetween(1,12);
        int year = getRandomIntBetween(startYear, endYear);

        return LocalDate.of(year,month,day);
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static List<Trainer> getTrainerList() {
        return trainerList;
    }

    public static List<Group> getGroupList() {
        return groupList;
    }
}
