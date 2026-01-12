package arsh.java.recursion;

public class skip {
    public static void main(String[] args) {
        SSkip("","bbcaddc");
    }
    static  void  SSkip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if (ch=='a'){
            SSkip(p,up.substring(1));
        }else{
            SSkip(p+ch,up.substring(1));
        }
    }
}
