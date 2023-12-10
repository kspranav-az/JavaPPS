import java.util.Scanner;

class Account{
    float balance = 0 ;
    Account(float n) {balance = n ;}
}

class BankCustomer{
    Account bal;
    BankCustomer(Account n){
        bal=n;
    }
    boolean CheckBalance(){
        return (bal.balance > 5000);
    }
    void setBalance(float n) {bal.balance = n ;}
    void Summary(){
        System.out.println(bal.balance);
    }
    void AddAmt(float add){}

    boolean WithdrawAmt(float sub) {
        return false;
    }
}

class Deposit extends BankCustomer{
    Deposit(Account n){
        super(n);
    }

    void AddAmt(float add){
        setBalance(bal.balance+add);
    }
}

class Withdraw extends BankCustomer{
    Withdraw(Account n){
        super(n);
    }

    boolean WithdrawAmt(float sub){
        if(CheckBalance() && (bal.balance - sub > 5000) ){
            setBalance(bal.balance-sub);
            return true ;
        }else {
            return false;
        }
    }
}


class Demo{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter balance amt: ");
        Account x = new Account(sc.nextFloat());
        BankCustomer B;

        while(true){
            try{
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.print("Enter your Choice (1/2): ");
                int ch=sc.nextInt();
                System.out.print("Enter amount: ");
                float amt=sc.nextFloat();
                if(ch==1){
                    B=new Deposit(x);
                    B.AddAmt(amt);
                    B.Summary();
                }else if(ch==2){
                    B=new Withdraw(x);
                    boolean flag = B.WithdrawAmt(amt);
                    if (!flag){
                        throw new MinimumBalanceException("minimum balance reached ...") ;
                    }
                    B.Summary();
                }else{
                    System.out.println("Invalid choice");
                    break;
                }
            }catch (MinimumBalanceException e){
                System.out.println(e);
                break;
            }
        }

    }
}

class MinimumBalanceException extends Exception{
    MinimumBalanceException(String msg){
        super(msg);
    }
}