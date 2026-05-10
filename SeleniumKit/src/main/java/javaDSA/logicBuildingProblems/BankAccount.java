package javaDSA.logicBuildingProblems;

import DBUtils.SQLconnection;

public class BankAccount {

    private String accountNumber;
    private double balance ;
    private boolean isActive;
    SQLconnection sqLconnection = new SQLconnection();

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.isActive = true;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public boolean isActive(){
        return isActive;
    }

    public void deposit(int amount){
        if(amount>0 && isActive){
            balance += amount;
        }else {
            System.out.println("Unauthorized Amount or Account INACTIVE");
        }
    }

    public void withDraw(int amount){
        if(isActive && amount<= balance && amount > 0){
            balance -= amount;
        }else {
            System.out.println("Insufficient Balance or Account INACTIVE");
        }
    }

    public void setActive(boolean active){
        this.isActive = active;
        if (!active){
            System.out.println("Account Deactivated!!!");
        }
    }

}
