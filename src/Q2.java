public class Q2 {
    public  static void main(String args[]){
        String fName = args[0] , lName = args[1];
        float height = Float.parseFloat(args[2]) , weight = Float.parseFloat(args[3]);

        float bmi = weight/(height*height) ;
        String cat ;
        System.out.println(fName + " " + lName);

        if(bmi<18.5){
            cat = "Under Weight" ;
        }else if(bmi < 25){
            cat = "Normal";
        }else if(bmi < 30){
            cat = "Over Weight" ;
        }else{
            cat = "Obese";
        }

        System.out.println(cat);
    }
}
