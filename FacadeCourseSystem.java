public class FacadeCourseSystem {
    private CourseSystem Ariel;
    public FacadeCourseSystem() {
        this.Ariel  = CourseSystem.instance();
    }

    public Student signUp_student(String name, String pass) {
        return Ariel.signUp_student(name, pass);
    }
    public Staff signUp_staff(String name, String pass, String type) {
        return Ariel.signUp_staff(name, pass, type);
    }
    public void logIn(Person person) {
        Ariel.logIn(person);
    }
    public void logOut(Person person) {
        Ariel.logOut(person);
    }
    public Course createCourseSystem(Staff staffMen, String n, int id, int max, String type) {
        return Ariel.createCourseSystem(staffMen, n, id, max, type);
    }
    public void signCourse(Student student, Course course) {
        student.signCourse(course);
    }
    public void unSignCourse(Student student, Course course) {
        student.unSignCourse(course);
    }
}
