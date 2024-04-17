import java.util.ArrayList;
import java.util.List;

public class CourseSystem {
    private String name;
    private List<Person> users;
    private List<Person> activates;
    private List<Course> courses;
    private static CourseSystem uniSystem = new CourseSystem("Ariel");

    private CourseSystem(String n) {
        this.name = n;
        this.users = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.activates = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public int getNumActivates(){
        return this.activates.size();
    }
    public int getNumUsers(){
        return this.users.size();
    }
    public static CourseSystem instance() {
        return uniSystem;
    }
    public Student signUp_student (String name, String pass){
        Student s = new Student(name, pass);
        this.users.add(s);
        return s;
    }
    public Staff signUp_staff (String name, String pass, String type){
        Staff user = Staff.staffFactory(name, pass, type);
        if(user != null) {
            this.users.add(user);
        }
        return user;
    }
    public void printCoursesUniversity(){
        System.out.println("List of the courses at " + this.name + " university:");
        for(Course course : this.courses)
            System.out.println("Name: " + course.name + ", ID: " + course.ID + ", Type: " + course.type);
    }
    public void logIn (Person person){
        if(users.contains(person) && this.activates.size() < 100){
            person.connect = true;
            System.out.println(person.name + " connected");
            this.activates.add(person);
        }
    }
    public void logOut (Person person){
        if(activates.contains(person)){
            System.out.println(person.name + " disconnected");
            person.connect = false;
            this.activates.remove(person);
        }
    }
    public Course createCourseSystem(Staff staffMen, String n, int id, int max, String type){
        boolean newCourse = true;
        Course exist = null;
        if(staffMen.connect) {
            for (int i = 0; i < this.courses.size(); i++) {
                if (id == this.courses.get(i).ID) {
                    newCourse = false;
                    System.out.println("This course is already exist");
                    exist = this.courses.get(i);
                }
            }
            if (newCourse) {
                Course c = staffMen.createCourse(n, id, max, type);
                if (c != null) {
                    this.courses.add(c);
                    System.out.println("The course: " + c.name + " created successfully!");
                    return c;
                }
            }
        }
        else
            System.out.println("Cannot create courses if you are not connect. Please sign in");
        return exist;
    }

}
