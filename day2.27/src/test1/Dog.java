package test1;

public class Dog extends Animal implements Swim{

    public Dog() {

    }

    public Dog(String name,int age) {
        super(name,age);
    }

    @Override
    public void eat(String food) {
        System.out.println("狗在吃"+food);
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }
}
