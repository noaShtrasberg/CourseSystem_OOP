public abstract class Person {
    protected String name;
    protected String password;
    protected boolean connect;

    public Person(String n, String pass){
        this.name = n;
        this.password = pass;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
}
