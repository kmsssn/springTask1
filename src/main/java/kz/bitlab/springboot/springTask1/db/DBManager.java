package kz.bitlab.springboot.springTask1.db;

import java.util.ArrayList;

public class DBManager {

    private static final ArrayList<Student> students=new ArrayList<>();
    private static Long id=5L;

    static{
        students.add(new Student(1L, "Ilyas", "Zhyanyshev", 88, "B"));
        students.add(new Student(2L, "Serik", "Erikov", 91, "A"));
        students.add(new Student(3L, "Erik", "Serikov", 65, "C"));
        students.add(new Student(4L, "Nurzhan", "Bolatov", 48, "F"));
    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        id++;
        students.add(student);
    }

}
