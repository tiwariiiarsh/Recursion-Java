package arsh.java.recursion;

import java.util.ArrayList;

public class subseq {
    public static void main(String[] args) {
//        ArrayList<String> result =ssubseqreq("","abc");
        System.out.println(ssubseqreq("","abc"));
//        ssubseq("", "abc");
    }
//    static  void ssubseq(String p,String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        char ch=up.charAt(0);
//        ssubseq(p+ch,up.substring(1));
//        ssubseq(p,up.substring(1));
//    }

    static ArrayList<String> ssubseqreq(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = ssubseqreq(p + ch, up.substring(1));
        ArrayList<String> right = ssubseqreq(p, up.substring(1));
        left.addAll(right);
        return left;
    }

}
