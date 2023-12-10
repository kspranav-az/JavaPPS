//import java.util.Scanner;
//
//interface Number{
//    int min(int num1,int num2);
//    int max(int num1,int num2);
//}
//
//class Sort implements Number{
//    int arr[];
//
//    Sort(int arr[]){
//        this.arr=arr;
//    }
//
//    public int min(int num1,int num2){
//        return (num1<num2)? 1:0 ;
//    }
//
//    public int max(int num1,int num2){
//        return (num1>num2)? 1:0 ;
//    }
//
//    boolean bool(int num){
//        return (num==1)? true: false;
//    }
//
//    void ascending(){
//        int temp;
//        for(int i=0;i<arr.length-1;i++){
//            int pos=i;
//            for(int j=i+1;j<arr.length;j++){
//                if(bool(min(arr[j],arr[pos]))){
//                    pos=j;
//                }
//            }
//            if(pos!=i){
//                temp=arr[pos];
//                arr[pos]=arr[i];
//                arr[i]=temp;
//            }
//        }
//        for(int num: arr){
//            System.out.print(num+" ");
//        }
//        System.out.println();
//    }
//
//    void descending(){
//        int temp;
//        for(int i=0;i<arr.length-1;i++){
//            int pos=i;
//            for(int j=i+1;j<arr.length;j++){
//                if(bool(max(arr[j],arr[pos]))){
//                    pos=j;
//                }
//            }
//            if(pos!=i){
//                temp=arr[pos];
//                arr[pos]=arr[i];
//                arr[i]=temp;
//            }
//        }
//        for(int num: arr){
//            System.out.print(num+" ");
//        }
//        System.out.println();
//    }
//}
//
//class Demo1 extends Sort{
//
//    Demo1(int arr[]){
//        super(arr);
//    }
//
//    public static void main(String args[]){
//
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the number of elements: ");
//        int n=sc.nextInt();
//        int arr[]=new int[n];
//        System.out.println("Enter the elements: ");
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//        }
//
//        Demo1 obj=new Demo1(arr);
//        System.out.println("Array in ascending order: ");
//        obj.ascending();
//        System.out.println("Array in descending order: ");
//        obj.descending();
//    }
//}