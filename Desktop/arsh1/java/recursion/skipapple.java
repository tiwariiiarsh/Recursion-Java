package arsh.java.recursion;

public class skipapple {
    public static void main(String[] args) {
        skip("","abcsfappledjguapple");
    }
    public static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(up.startsWith("apple")){
            skip(p,up.substring(5));
        }else{
            skip(p+ch,up.substring(1));
        }
    }
}
