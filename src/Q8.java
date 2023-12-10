import java.util.Scanner;

public class Q8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int integer = 0 ,flt = 0,strNum = 0;
        float avgInteger = 0f , avgflt = 0f ;

        while(strNum!=3){
            String str = sc.next();

            boolean isFlt = str.matches("-?\\d+\\.\\d+");
            boolean isInt = str.matches("-?\\d+");

            if(isInt){
                integer++;
                avgInteger += Integer.parseInt(str);
            } else if (isFlt){
                flt++;
                avgflt += Float.parseFloat(str);
            }else {
                strNum++;
            }
        }

        avgInteger = integer != 0 ? avgInteger / integer : 0;
        avgflt = flt!=0 ? avgflt/flt : 0 ;
        System.out.println("integers : "+integer+
                "\navg of integers : "+avgInteger+
                "\nfloats : "+flt+"\navg of floats : "+avgflt);
    }
}
