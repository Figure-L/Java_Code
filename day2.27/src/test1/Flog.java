package test1;

public class Flog extends Animal implements Swim{

    public Flog(){

    }

    public Flog(String name,int age){
        super(name,age);
    }

    public void eat(String food){
        System.out.println("青蛙在吃"+food);
    }


    @Override
    public void swim() {
        System.out.println("蛙泳");
    }
}
