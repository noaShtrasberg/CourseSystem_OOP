import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person implements Observer {
    private List<Course> coursesList;

    public Student(String n, String pass) {
        super(n, pass);
        this.coursesList = new ArrayList<>();
    }
    public List<Course> getCoursesList(){
        return this.coursesList;
    }
    public void signCourse(Course c) {
        if (this.connect) {
            if (!(c.students.contains(this))) {
                if (c.maxStudents > c.students.size()) {
                    this.coursesList.add(c);
                    c.students.add(this);
                    c.waiters.remove(this);
                    System.out.println(this.name + " signed to course " + c.name + " successfully");
                } else {
                    System.out.println("This course is full. Would you like to be notified when a space becomes available? [Y/N]");
                    Scanner scanner = new Scanner((System.in));
                    String answer = scanner.nextLine();
                    if (answer.equals("Y"))
                        c.waiters.add(this);
                }
            }
            else
                System.out.println("This student is already in this course");
        }
        else
            System.out.println("Cannot sign to courses if you are not connect. Please sign in");
    }

    public void unSignCourse(Course c) {
        if (this.connect) {
            if (c.students.contains(this)) {
                this.coursesList.remove(c);
                c.students.remove(this);
                System.out.println(this.name + "unsigned to course " + c.name + " successfully");
            }
            if ((c.students.size()+1) == c.maxStudents)
                c.notifyObservers();
        }
    }
    public void printCoursesStudent(){
        System.out.println("List of the courses that " + this.name + " is enrolled in:");
        for(Course course : this.coursesList)
            System.out.println("Name: " + course.name + ", ID: " + course.ID);
    }
    @Override
    public void update(Course course) {
        System.out.println("Hello " + this.name + ": A place has become available in course: " + course.name);
    }
}
