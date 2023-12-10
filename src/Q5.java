import java.util.Scanner;

public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt() ;
        int order = 1, temp = num;

        while(temp>0){
            temp/=10;
            order*=10;
        }
        order/=10;

        while(true){

            temp = num/order;
            num%=order;
            order/=10;

            System.out.print(temp);
            if(order==0){
                break;
            }
            System.out.print("$");
        }
        System.out.println();
    }
}
