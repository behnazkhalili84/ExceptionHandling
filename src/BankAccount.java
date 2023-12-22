import java.util.Scanner;

class BankAccountException extends Exception {
    public BankAccountException(String s) {
        super( s );
    }

    public String getMessage() {
        return super.getMessage();
    }
}

class InvalidAmountException extends BankAccountException {
    public InvalidAmountException() {
        super( "The mount is invalid." );
    }

    public String getMessage() {
        return super.getMessage();
    }
}

class NotEnoughBalanceException extends BankAccountException {

    public NotEnoughBalanceException() {
        super( "There is not enough balance in the account" );
    }

    public String getMessage() {
        return super.getMessage();
    }

}

class WithdrawLimitException extends BankAccountException {
    public WithdrawLimitException() {
        super( "The amount is greater than the withdraw limit." );
    }

    public String getMessage() {
        return super.getMessage();
    }
}

class DepositLimitException extends BankAccountException {
    public DepositLimitException() {
        super( "The amount is over the limit." );
    }

    public String getMessage() {
        return super.getMessage();
    }
}

public class BankAccount {
    //import Exception.*;

    private String name; // your name
    private double balance; // current amount of money you save in the bank account
    private final static double depositLimit = 500;
    private final static double withdrawLimit = 500;

    /**
     * constructor
     */
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    /**
     * constructor
     */
    public BankAccount(String name) {
        this( name, 0 );
    }

    /**
     * return balance
     */
    public double getbalance() {
        return balance;
    }

    /**
     * return name
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + "\n" + "balance: " + balance;
    }

    /**
     * deposit money into the account
     */
    public void deposit(double depositAmount) throws BankAccountException {
        try {
            if (depositAmount <= 0) {
                throw new InvalidAmountException();
            } else if (depositAmount > 500) {
                throw new DepositLimitException();
            } else {
                balance = balance + depositAmount;
                System.out.println( "Current balance : " + balance );
            }
        } catch (InvalidAmountException e) {
            String s = e.getMessage();
            System.out.println( s );
        }

    }

    /**
     * withdraw money from the account
     */
    public void withdraw(double withdrawAmount) throws BankAccountException {
        try {
            if (withdrawAmount <= 0) {
                throw new InvalidAmountException();
            } else if (withdrawAmount > 500) {
                throw new WithdrawLimitException();
            } else if (withdrawAmount > balance) {
                throw new NotEnoughBalanceException();
            } else {
                balance = balance - withdrawAmount;
                System.out.println( "Current balance : " + balance );
            }
        } catch (InvalidAmountException e) {
            String s = e.getMessage();
            System.out.println( s );
        } catch (WithdrawLimitException e) {
            String s = e.getMessage();
            System.out.println( s );
        } catch (NotEnoughBalanceException e) {
            String s = e.getMessage();
            System.out.println( s );
        }
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner( System.in );
        System.out.println("Enter your name : ");
        String name = kb.nextLine();
        double balance = 2000;
        BankAccount bankAccount = new BankAccount( name ,balance);
        System.out.println( "Enter the amount you want to deposit : " );
        double depAmount = kb.nextDouble();
        try{
            bankAccount.deposit( depAmount );
        }catch(BankAccountException e){
            String s = e.getMessage();
            System.out.println(s);
        }

        System.out.println("Enter the amount you want to withdraw : ");
        double withdrawamount = kb.nextDouble();
        try{
            bankAccount.withdraw( withdrawamount );
        }catch(BankAccountException e){
            String s = e.getMessage();
            System.out.println(s);
        }
    }

}
 