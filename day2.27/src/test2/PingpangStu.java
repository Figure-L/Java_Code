package test2;

public class PingpangStu extends Student implements SpeakEnglish {

    public PingpangStu() {

    }
    public PingpangStu(String name, int age) {
        super(name,age);
    }


    @Override
    public void study() {
        System.out.println("study pingpang");
    }

    @Override
    public void speakEnglish() {
        System.out.println("speak english");
    }



}
