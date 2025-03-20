package test2;

public class test {
    public static void main(String[] args) {
        //创建实体类变量
        BasketballStu bs = new BasketballStu("bstu",22);
        BasketballTch bt = new BasketballTch("btch",22);

        PingpangStu ps = new PingpangStu("pst",22);
        PingpangTch pt = new PingpangTch("ptch",22);
        System.out.println(bs.getName()+","+bs.getAge());
        bs.study();
        System.out.println(bt.getName()+","+bt.getAge());
        bt.teach();
        System.out.println(ps.getName()+","+ps.getAge());
        ps.study();
        ps.speakEnglish();
        System.out.println(pt.getName()+","+pt.getAge());
        pt.teach();
        pt.speakEnglish();
    }
}
