package com.example.implementtest;


import java.util.ArrayList;
import java.util.Random;

public class TEST{

    private static int length;
    private static int current;

    private static int length2;
    private static int current2;

    private static int length3;
    private static int current3;
    public static void main(String[] args) throws Exception {
        Random rnd=new Random();
        int a=rnd.nextInt(100)+1;
        int b=rnd.nextInt(100)+1;

        System.out.println("a="+a+"/"+"b="+b);
        System.out.println("ans="+(a+b));
        System.out.println("右移3位:"+((a+b)>>3));
        StringBuilder sb=new StringBuilder("测试字串");
        sb.append("+1");

        System.out.println(sb);

        ArrayList  array=new ArrayList<String>(5);
        System.out.println("阵列大小:"+array.size());
        for(int i=0;i<10;i++){
            String s=Integer.toString(i);
            array.add(s);

            System.out.println(s);

        }
        System.out.println("阵列大小:"+array.size());

        length=9;
        current=length;
        while(current>=1){
            next(current);

        }
        System.out.println("end");


    }

    public static int next(int c){

        for(int i=1;i<=c;i++){
                System.out.print(i);
            }

        System.out.println();
        current--;
        return current;
    }


}
