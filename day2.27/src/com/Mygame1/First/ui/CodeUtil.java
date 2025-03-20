package com.Mygame1.First.ui;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        //生成验证码
        //1.创建数组  一个存放所有字母 一个存放需要的验证码
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }

        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int index = 0;
        for(int i=0;i<4;i++){
            index = r.nextInt(list.size());
            sb.append(list.get(index));
        }

        sb.append(r.nextInt(10));

        char[] chars = sb.toString().toCharArray();

        index = r.nextInt(chars.length);
        char ch = chars[index];
        chars[index] = chars[4];
        chars[4] = ch;

        String code = new String(chars);


        return code;

    }
}
