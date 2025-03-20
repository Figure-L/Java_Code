package test2;

public class PingpangTch extends Teacher implements SpeakEnglish{
    public PingpangTch() {

    }
    public PingpangTch(String name,int age) {
        super(name,age);
    }

    @Override
    public void speakEnglish() {
        System.out.println("speakEnglish");
    }

    @Override
    public void teach() {
        System.out.println("teach Pingpang");
    }
}
