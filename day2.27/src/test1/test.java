package test1;

public class test {
    public static void main(String[] args) {
        Flog f = new Flog("qq",3);
        Dog d = new Dog("ww",2);
        Rabbit r = new Rabbit("tt",1);
        System.out.println(f.getName()+","+f.getAge());
        f.eat("虫子");
        System.out.println(d.getName()+","+d.getAge());

        d.eat("骨头");
        System.out.println(r.getName()+","+r.getAge());

        r.eat("胡萝卜");

        f.swim();
        d.swim();

    }
}
