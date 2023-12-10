import java.util.ArrayList;
import java.util.Scanner;

public class Q12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] tutors = new int[4][];

        for(int i = 0 ; i < 4 ; i++){
            System.out.println("Enter Marks of batch-> " + (i+1));

            int mark = -1 ,count = 0 ;
            do{

                mark = sc.nextInt();
                count += ((mark < 25) && (mark!=-1)) ? 1 : 0 ;

            }while(mark!=-1);

            int len = count % 4 == 0 ? (count / 4) : (count / 4 + 1);
            tutors[i] = new int[len];
            for(int j = 0; j < len; j++){
                tutors[i][j] = count - 4 > 0 ? 4 : count ;
                count-=4 ;
            }


        }
        int count = 0 ;
        for (int[] i : tutors){
            for (int j : i ){
                count += j==4?0:1 ;
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("No of Batchs in which all tutors\n" +
                "have exactly 4 students : " + (4-count)) ;

    }
}
