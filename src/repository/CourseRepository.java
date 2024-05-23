package repository;



import exception.ExceptionNotFound;
import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;


import java.util.*;
import java.util.stream.Collectors;


public class CourseRepository {
    static List<Course> courses = new ArrayList<>();
    public static List<Course> getAllCourses() {
        System.out.print("[*] Insert title:");
        String title = new Scanner(System.in).nextLine().toUpperCase().trim();
        System.out.print("[*] Insert instructor name:");
        String [] instructorName = new Scanner(System.in).nextLine().toUpperCase().split(" ");
        System.out.print("[*] Insert requirement:");
        String [] requirement = new Scanner(System.in).nextLine().toUpperCase().split(",");
        Integer id = (int) (Math.random()*2000)+1000;
        courses.add(new Course(id.toString(),title,instructorName,requirement, new Date()));
        return courses;
    }
    public static List<Course> listAllCourses() {

        Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        table.addCell("ID");
        table.addCell("TITLE");
        table.addCell("INSTRUCTOR NAME");
        table.addCell("REQUIREMENT");
        table.addCell("DATE");
        courses.forEach(course -> {
            table.addCell(course.getId());
            table.addCell(course.getTitle());
            table.addCell(Arrays.toString(course.getInstructorName()));
            table.addCell(Arrays.toString(course.getRequirement()));
            table.addCell(course.getStartDate().toString());
        });
        System.out.println(table.render());

        return courses;
    }
    public static List<Course> findCourseById() throws ExceptionNotFound {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        System.out.print("[*] Insert id:");
       String id = new Scanner(System.in).nextLine().trim();
        table.addCell("ID");
        table.addCell("TITLE");
        table.addCell("INSTRUCTOR NAME");
        table.addCell("REQUIREMENT");
        table.addCell("DATE");
        List <Course> listCourse = courses.stream().filter(c->c.getId().equals(id)).collect(Collectors.toList());
        try {
            if (listCourse.isEmpty()) {
                throw new ExceptionNotFound("[!] Id [" + id + "] Not Found");
            } else {
                listCourse.forEach(course -> {
                    table.addCell(course.getId());
                    table.addCell(course.getTitle());
                    table.addCell(Arrays.toString(course.getInstructorName()));
                    table.addCell(Arrays.toString(course.getRequirement()));
                    table.addCell(course.getStartDate().toString());
                });
            }
            System.out.println(table.render());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }
    public static List<Course> findCourseByTitle() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        System.out.print("[*] Insert title:");
        String title = new Scanner(System.in).nextLine().toUpperCase().trim();
        table.addCell("ID");
        table.addCell("TITLE");
        table.addCell("INSTRUCTOR NAME");
        table.addCell("REQUIREMENT");
        table.addCell("DATE");
        List <Course> listCourse = courses.stream().filter(c->c.getTitle().contains(title)).collect(Collectors.toList());
        try {
            if (listCourse.isEmpty()) {
                throw new ExceptionNotFound("[!] Title [" + title + "] Not Found");
            } else {
                listCourse.forEach(course -> {
                    table.addCell(course.getId());
                    table.addCell(course.getTitle());
                    table.addCell(Arrays.toString(course.getInstructorName()));
                    table.addCell(Arrays.toString(course.getRequirement()));
                    table.addCell(course.getStartDate().toString());
                });
            }
            System.out.println(table.render());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }
    public static List<Course> removeCourseById() {
        System.out.print("[*] Insert id:");
        String id = new Scanner(System.in).nextLine().trim();
        List <Course> listCourse = courses.stream().filter(c->c.getId().equals(id)).collect(Collectors.toList());
        try {
            if (listCourse.isEmpty()) {
                throw new ExceptionNotFound("[!] Id [" + id + "] Not Found");
            }else{
                courses.removeIf(c -> c.getId().equals(id));
                System.out.println("[*] Remove course successfully");
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return courses;
    }
}
