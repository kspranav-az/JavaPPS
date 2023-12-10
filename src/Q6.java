import java.util.Scanner;

public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
        while(num!=1){
            System.out.println(num = (num & 1) == 1 ? (num * 3 + 1) : num/2);
        }
    }
}
