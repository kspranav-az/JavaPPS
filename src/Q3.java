import java.util.Random;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args){
        int rand_num = new Random().nextInt(100);

        Scanner sc = new Scanner(System.in);
        int num;

        while(true){
            num = sc.nextInt();

            if(num == rand_num ){
                System.out.println("Congratulations! You got it..");
                break;
            }else if(num > rand_num){
                System.out.println("too high");
            }else{
                System.out.println("too low");
            }
        }
    }
}
