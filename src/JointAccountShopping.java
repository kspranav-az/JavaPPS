class JointAccount {
    private int balance = 25000;

    synchronized void doShopping(String shopper, int expense) throws InsufficientBalanceException {
        if (balance - expense < 5000) {
            throw new InsufficientBalanceException("Shopping not allowed for " + shopper + ". Insufficient balance.");
        }

        System.out.println(shopper + " is shopping for Rs." + expense);
        balance -= expense;
        System.out.println("Remaining balance after " + shopper + "'s shopping: Rs." + balance);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ShoppingTask implements Runnable {
    private JointAccount jointAccount;
    private String shopper;
    private int expense;

    public ShoppingTask(JointAccount jointAccount, String shopper, int expense) {
        this.jointAccount = jointAccount;
        this.shopper = shopper;
        this.expense = expense;
    }

    @Override
    public void run() {
        try {
            while(true){
                jointAccount.doShopping(shopper, expense);
                Thread.sleep(1000);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class JointAccountShopping {
    public static void main(String[] args) {
        JointAccount jointAccount = new JointAccount();
        Thread husbandThread = new Thread(new ShoppingTask(jointAccount, "Husband", 1050));
        Thread wifeThread = new Thread(new ShoppingTask(jointAccount, "Wife", 1300));

        husbandThread.start();
        wifeThread.start();

        try {
            husbandThread.join();
            wifeThread.join();
        }catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}