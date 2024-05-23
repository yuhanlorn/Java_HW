package service;

import exception.ExceptionNotFound;
import model.Course;
import repository.CourseRepository;

import java.util.List;

public class CourseServiceImp implements CourseService {
    @Override
    public List<Course> addNewCourses() {
        return CourseRepository.getAllCourses();
    }

    @Override
    public List<Course> listAllCourses() {
        return CourseRepository.listAllCourses();
    }

    @Override
    public List<Course> findCoursesById() throws ExceptionNotFound {
        return CourseRepository.findCourseById();
    }

    @Override
    public List<Course> findCoursesByTitle() {
        return CourseRepository.findCourseByTitle();
    }

    @Override
    public List<Course> removeCourseById() {
        return CourseRepository.removeCourseById();
    }
}
