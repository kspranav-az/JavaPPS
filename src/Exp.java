import java.util.Scanner;

class InvalidEmployeeCodeException extends Exception {
    InvalidEmployeeCodeException(String msg){
        super(msg);
    }
}

class Employee {
    String EmpID,Name,Yob ;

    Employee(String eid , String name , String yob){
        this.EmpID = eid ;
        this.Name = name ;
        this.Yob = yob ;
    }

    void printDetail(){
        System.out.println("\nEmployeeID : " + EmpID +
                "\nName : "+ Name +"\nYear of Birth : " + Yob) ;
    }
}


public class Exp{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Employee e1 ;
        String tempName = sc.next();
        String tempYob = sc.next();
        try{
            String tempID = sc.next();
            if(tempID.matches("[0-9]{2}-[FS]-[0-9]{3}")){
                e1 = new Employee(tempID,tempName,tempYob) ;
                e1.printDetail();
            }else{
                throw new InvalidEmployeeCodeException("Invalid Employee  Code");
            }
        }catch(InvalidEmployeeCodeException e){
            System.out.println(e);
        }
    }
}