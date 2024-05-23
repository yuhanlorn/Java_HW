package service;

import exception.ExceptionNotFound;
import model.Course;

import java.util.List;

public interface CourseService {
    List<Course> addNewCourses();
    List<Course> listAllCourses();
    List<Course> findCoursesById() throws ExceptionNotFound;
    List<Course> findCoursesByTitle();
    List<Course> removeCourseById();
}
