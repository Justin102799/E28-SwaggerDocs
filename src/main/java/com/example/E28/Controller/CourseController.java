package com.example.E28.Controller;

import com.example.E28.Entity.Course;
import com.example.E28.Entity.Student;
import com.example.E28.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public @ResponseBody String addCourse(@RequestParam String courseName,
                                          @RequestParam String description) {
        return courseService.addCourse(courseName, description);
    }

    @GetMapping("/allCourse")
    public @ResponseBody List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    @GetMapping(path = "/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setCourseId(id);
        return courseService.update(id, course);
    }

}
