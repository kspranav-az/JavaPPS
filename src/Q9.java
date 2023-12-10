public class Q9 {
    public static void pattern_a(int n){
        for(int i = 1 ; i <= n ; i++){

            for(int j = 1 ; j <= i ; j++){
                System.out.print(j + "  ");
            }
            for(int j = i - 1  ; j > 0 ; j--){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
    public static void  pattern_b(int n ){

        for(int i = 1 ; i <= 2*n-1 ; i++){

            for(int j = i<=n?i:(2*n-i) ; j <= n ; j++){
                System.out.print(j + "  ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args){
        pattern_a(5);
        System.out.println("---------------------------");
        pattern_b(7);
    }

}
