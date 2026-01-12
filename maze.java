package arsh.java.recursion;

public class maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
    }
    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
//        int left = count(r-1, c);
//        int right = count(r, c-1);
//        return left + right;

//        we can also write this
      return count(r-1, c) + count(r, c-1);

    }

}
