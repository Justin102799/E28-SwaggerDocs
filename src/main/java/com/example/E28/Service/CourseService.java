package com.example.E28.Service;

import com.example.E28.Entity.Course;
import com.example.E28.Entity.Student;
import com.example.E28.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public String addCourse(String courseName, String description) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDescription(description);
        courseRepository.save(course);
        return "Course Saved!";
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Long id, Course course) {
        course.setCourseId(id);
        return courseRepository.save(course);
    }
}
