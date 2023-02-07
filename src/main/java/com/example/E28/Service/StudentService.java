package com.example.E28.Service;

import com.example.E28.Entity.Course;
import com.example.E28.Entity.Student;
import com.example.E28.Repository.CourseRepository;
import com.example.E28.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(Long id, Student student) {
        student.setStudentId(id);
        return studentRepository.save(student);
    }

    public Student enrollStudent(Long studentId, Course course) {
        Student student=studentRepository.findById(studentId).get();
        student.getCourses().add(courseRepository.findById(course.getCourseId()).get());
        studentRepository.save(student);
        return student;

    }

    public Student dropStudent(Long id, Course course) {
        Student student=studentRepository.findById(id).get();
        student.getCourses().remove(courseRepository.findById(course.getCourseId()).get());
        studentRepository.save(student);
        return student;
    }
}

