public class Main {
    public static void main(String[] args) {
        FacadeCourseSystem Ariel = new FacadeCourseSystem();
        Student Noa = Ariel.signUp_student("Noa", "12345");
        Ariel.logIn(Noa);
        Staff Eran = Ariel.signUp_staff("Eran", "12345", "Lecturer");
        Course OOP3 = Ariel.createCourseSystem(Eran, "OOP", 2468, 2, "Seminar"); // Eran is not connect
        Ariel.logIn(Eran);
        Course OOP = Ariel.createCourseSystem(Eran, "OOP", 2468, 2, "Seminar");
        Course SP = Ariel.createCourseSystem(Eran, "SP", 3579, 2, "Required");
        Course OOP2 = Ariel.createCourseSystem(Eran, "OOP2", 2468, 2, "Optional");
        System.out.println(OOP2.type); // same ID like OOP, should print the type of OOP - Seminar
        Ariel.signCourse(Noa, OOP);
        Student Hagit = Ariel.signUp_student("Hagit", "12345");
        Student Yair = Ariel.signUp_student("Yair", "12345");
        Ariel.logIn(Hagit);
        Ariel.logIn(Yair);
        Ariel.signCourse(Hagit, OOP);
        Ariel.signCourse(Yair, OOP); // OOP is full. ask Yair if he wants to sign for updates
        Ariel.unSignCourse(Noa, OOP);
        Ariel.signCourse(Yair, OOP); // now Yair can sign to OOP
    }
}