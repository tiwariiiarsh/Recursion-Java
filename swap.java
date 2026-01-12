package arsh.java.recursion;

import org.w3c.dom.ls.LSOutput;

public class swap {
    public static void main(String[] args) {
        int a=10;
        int b=2;
        swap(a,b);
//    swap(a,b);
//        System.out.println(a+" "+b);
    }
   static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
       System.out.println(a+" "+b);
   }
}
