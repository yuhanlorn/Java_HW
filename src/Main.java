import exception.ExceptionNotFound;
import repository.CourseRepository;
import view.View;


public class Main {
    public static void main(String[] args) throws ExceptionNotFound {
        String choice;
        boolean exit = false;
        while (!exit) {
            View.menu();
            choice = View.inputChoice();
            switch (choice) {
                case "1"-> CourseRepository.getAllCourses();
                case "2"->CourseRepository.listAllCourses();
                case "3"->CourseRepository.findCourseById();
                case "4"->CourseRepository.findCourseByTitle();
                case "5"->CourseRepository.removeCourseById();
                case "0","99"-> {exit = true;}
                default -> System.out.println("Invalid choice");
            }

        }
    }
}