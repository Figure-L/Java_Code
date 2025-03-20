package test2;

//因为不想让他直接被调用创建人的对象
//因为直接创建顶层父类的信息是没有意义的
public abstract class Person {
    private String name;
    private int age;
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
