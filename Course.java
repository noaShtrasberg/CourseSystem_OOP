import java.util.ArrayList;
import java.util.List;

public abstract class Course{
    protected String name;
    protected int ID;
    protected int maxStudents;
    protected String type;
    protected List<Student> students;
    protected ArrayList<Observer> waiters;
    public Course(String n, int id, int max){
       this.students = new ArrayList<>();
       this.waiters = new ArrayList<>();
       this.name = n;
       this.ID = id;
       this.maxStudents = max;
    }
    public static Course courseFactory(String n, int id, int max, String type){
        if(type.equals("Required"))
            return new Required(n, id, max, type);
        else if(type.equals("Optional"))
            return new Optional(n, id, max, type);
        else if(type.equals("Seminar"))
            return new Seminar(n, id, max, type);
        return null;
    }
    public void printStudents(){
        System.out.println("List of the students at " + this.name + " course:");
        for(Student student : this.students)
            System.out.println("Name: " + student.name);
    }
    public void notifyObservers(){
        for (Observer ob : waiters)
            ob.update(this);
    }
}
