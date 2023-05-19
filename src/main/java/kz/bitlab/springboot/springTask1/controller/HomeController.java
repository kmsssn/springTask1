package kz.bitlab.springboot.springTask1.controller;

import kz.bitlab.springboot.springTask1.db.DBManager;
import kz.bitlab.springboot.springTask1.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String index(Model model){
        ArrayList<Student> students=DBManager.getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(value="/add-student")
    public String add_student(){
        return "addStudent";
    }

    @PostMapping(value="/addStudent")
    public String addStudent(@RequestParam(name="name") String name,
                             @RequestParam(name="surname") String surname,
                             @RequestParam(name="exam") int exam){
        String mark="";
        if(exam>=90){
            mark="A";
        }else if(exam<=89 && exam>=75){
            mark="B";
        }else if(exam<=75 && exam>=60){
            mark="C";
        }else if(exam<=59 && exam>=50){
            mark="D";
        }else{
            mark="F";
        }
        Student s=new Student();
        s.setName(name);
        s.setSurname(surname);
        s.setExam(exam);
        s.setMark(mark);
        DBManager.addStudent(s);
        return "redirect:/";
    }

}
