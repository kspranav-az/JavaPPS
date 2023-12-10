import java.util.Arrays;
import java.util.Scanner;

public class Gen {

    public static <E> void swap(E[] arr, int i , int j){
        E temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in) ;
        int n = sc.nextInt();
        Integer abc[]= new Integer[n] ;
        for(int i = 0 ; i < n ; i++){
            abc[i] = sc.nextInt();
        }
        swap(abc,2,4);
        System.out.println(Arrays.toString(abc));
    }
}
