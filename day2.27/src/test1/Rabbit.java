package test1;

public class Rabbit extends Animal {

    public Rabbit() {

    }

    public Rabbit(String name,int age) {
        super(name,age);
    }

    @Override
    public void eat(String food) {
        System.out.println("兔子在吃"+food);
    }


}
