public abstract class Staff extends Person{
    public Staff(String n, String pass){
       super(n, pass);
    }
    public static Staff staffFactory(String name, String password, String type){
        if(type.equals("Lecturer"))
            return new Lecturer(name, password);
        else if(type.equals("Practitioner"))
            return new Practitioner(name, password);
        return null;
    }
    public Course createCourse(String name, int num, int max, String type){
        return Course.courseFactory(name, num, max, type);
    }
}
