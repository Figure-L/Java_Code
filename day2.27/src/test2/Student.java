package test2;

public abstract class Student extends Person {
    public Student() {

    }
    public Student(String name,int age) {
        super(name, age);
    }

    public abstract void study();

}
