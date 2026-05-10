package javaDSA.logicBuildingProblems;

import DBUtils.SQLconnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class BankAccount {

    private String accountNumber;
    private double balance ;
    private boolean isActive;
    SQLconnection sqLconnection = new SQLconnection();
    BasicProblems BP = new BasicProblems();
    public BankAccount(){
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

    public void fetchAccountDetails(String accountNumber) throws SQLException {
        List<Map<String, Object>> list =  sqLconnection.connect().executeQuery("select * from bank_account where account_number = " + accountNumber +";");
        System.out.println("List::"+list);
        Map<String, Object> record = list.get(0);
        this.accountNumber = String.valueOf(record.get("account_number"));
        this.balance = (Float) record.get("balance");
        this.isActive = (Boolean) record.get("isActive");
    }

    public void createAccount() throws SQLException {
        accountNumber = String.valueOf(BP.generateAccountNumber());
        sqLconnection.connect().executePreparedUpdate(
                "INSERT INTO bank_account (account_number,name, email, gender, date_of_birth) VALUES (?, ?, ?, ?, ?)",
                accountNumber,"Pradeep Sharma", "pradeep@gmail.com", "Male", "1990-01-01"
        );
    }

}
