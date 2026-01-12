package arsh.java.recursion;

public class reverse2 {
    public static void main(String[] args) {
//        rev1(1234, 0);
        System.out.println(rev1(1234, 0));

    }

    static int rev1(int n, int sum) {
//        int sum=0;
        if (n == 0) {
            return sum;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
       return rev1(n / 10, sum);
//
    }
}
