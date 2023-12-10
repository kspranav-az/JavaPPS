import java.lang.Math;

interface Number{
    void Prime(int n);
}

interface Factor{
    void List_Factors(int n);
}

class Armstrong implements Number,Factor{

    public void List_Factors(int n){
        System.out.print(n +"- not prime and its factors are: ");
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public void Prime(int n){
        int count=0;
        for(int i=2;i<n;i++){
            if(n%i==0){
                count+=1;
            }
        }
        if(count==0){
            System.out.println(n +"- prime");
        }else{
            List_Factors(n);
        }
    }


    static boolean IsArmstrong(int n){
        int num,rem,x=0,count=0;
        num=n;
        while(num>0){
            count++;
            num/=10;
        }
        num=n;
        while(num>0){
            rem=num%10;
            x+=Math.pow(rem,count);
            num/=10;
        }
        return (x==n)? true:false ;
    }

    void printNumber(int n){
        Prime(n);
    }

    public static void main(String args[]){
        Armstrong obj=new Armstrong();
        System.out.println("The Armstrong numbers from 1 to 1000 are: ");
        for(int i=1;i<=1000;i++){
            if(IsArmstrong(i)){
                obj.printNumber(i);
            }
        }
    }

}