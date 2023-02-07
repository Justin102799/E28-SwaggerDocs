package com.example.E28.Controller;

import com.example.E28.Entity.Course;
import com.example.E28.Entity.Student;
import com.example.E28.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/allStudent")
    public @ResponseBody List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping(path = "/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        studentService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
    student.setStudentId(id);
    return studentService.update(id, student);
    }
    @PutMapping("/students/{id}enroll")
    public Student enroll(@PathVariable("id") Long id, @RequestBody Course course){
        return studentService.enrollStudent(id, course);
    }
    @DeleteMapping("/students/{id}/drop")
    public Student dropStudent(@PathVariable("id") Long id, @RequestBody Course course) {
        studentService.dropStudent(id, course);
        return studentService.dropStudent(id,course);
    }

}
