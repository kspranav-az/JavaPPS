import java.util.Scanner;

public class Q11 {

    public static void main(String[] args){
        float[] rain = new float[12];
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 12 ; i++){
            rain[i] = sc.nextFloat() ;
        }
        float avg = 0 ;
        int  count = 0 ;
        for(float i : rain){
            avg+=i;
        }
        avg/=12;
        System.out.println("Average Rainfall : " + String.format("%.4f",avg) );
        for(float i : rain){
            if(i>avg){
                count++;
            }
        }
        System.out.println("number of months with above average rainfall : " + count );
    }
}
