package arsh.java.recursion;

public class productofdigits {
    public static void main(String[] args) {
        int ans= product(555);
        System.out.println(ans);
    }
    static int product(int n){
        if(n%10==n){
            return n;
        }
        return product(n/10)*(n%10);
    }
}
