public class Q10 {

    public static int sum_Squares(int n){
        int sum = 0 ;
        while(n>0){
            sum+= n * n-- ;
        }
        return sum ;
    }

    public int Square_sum(int n){
        int sum = 0 ;
        while(n>0){
            sum += n--;
        }
        return sum*sum ;
    }

    public static void main(String[] args){
        Q10 obj = new Q10() ;
        System.out.println(sum_Squares(5));
        System.out.println(obj.Square_sum(5));
    }
}
