package arsh.java.recursion;

public class countzeroes {
    public static void main(String[] args) {
        System.out.println(count(30204));
    }
    static int count(int n){
        return helper(n,0);
    }
    private static int helper(int n,int c){
//          c=0;
        if(n==0){
            return c;
        }
        int rem=n%10;
        if(rem==0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);
    }
}
