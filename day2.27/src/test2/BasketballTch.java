package test2;

public class BasketballTch extends Teacher{
    public BasketballTch(){

    }
    public BasketballTch(String name,int age){
        super(name,age);
    }

    @Override
    public void teach() {
        System.out.println("teach Basketball");
    }

}
