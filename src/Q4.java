import java.util.Scanner;

public class Q4 {
    public static void main(String args[]){
        int T1 = 1 , T2  = 0 , T3 = 0 ;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0 ,temp ; i < n ; i++){

            temp = T1 + T2 + T3 ;
            T1 = T2;
            T2 = T3;
            T3 = temp;

            System.out.print(T3 + " ");
        }

    }
}
