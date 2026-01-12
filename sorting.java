package arsh.java.recursion;

public class sorting {
    public static void main(String[] args) {
        int[]arr={1,2,3,41,0,5,6};
        System.out.println(sort(arr,0));
    }
    static  boolean sort(int[] arr,int index){
        if(index == arr.length - 1){
           return true;
        }
        return arr[index]<arr[index+1] && sort(arr,index+1);
    }
}
