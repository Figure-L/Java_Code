package test2;

public class BasketballStu extends Student{
    public BasketballStu() {

    }

    public BasketballStu(String name,int age) {
        super(name,age);
    }

    @Override
    public void study() {
        System.out.println("study Basketball");
    }

}
