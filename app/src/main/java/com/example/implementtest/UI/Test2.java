package com.example.implementtest.UI;

public class Test2 {
    private static int length;
    private static int current;
    private static int block;


    public static void main(String[] args) throws Exception {
     length=9;
     current=length;
     while(current>=1){
         next(current);
     }


     current=9;
     System.out.println("TASK2");
     while(current>=1){
         next2(current);
     }
        System.out.println("TASK2_Ending!>~<");



    }

    public static int next(int c){

        for(int i=1;i<=length;i++){
            if(c>=i){
                System.out.print(i);
                }else {System.out.print(" "); }

        }
        System.out.println();


        current--;


        return current;
    }

    public static int next2(int c){
//        int block=(length-current)/2;
//        for(int i=0;i<=block;i++){
//            System.out.print(" ");
//        }
//        for(int i=1;i<=c;i++){
//            System.out.print(i);
//
//        }
//        for(int i=0;i<=block;i++){
//            System.out.print(" ");
//        }
//        System.out.println();
//
//
//        current-=2;
//
//        return current;
        for(int i=1;i<=length;i++){

            if(i<=block || i>length-block){
                System.out.print(" ");
            }else{
                System.out.print(i-block);
            }


        }
        System.out.println();

        current-=2;
        block++;
        return current;
    }
}
