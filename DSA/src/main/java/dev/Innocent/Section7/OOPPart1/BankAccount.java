package dev.Innocent.Section7.OOPPart1;

public class BankAccount {
    private int accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(int accountNumber, double accountBalance, String customerName,
                       String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double depositAmount){
        accountBalance += depositAmount;
        System.out.println("Deposit of $" + depositAmount + " made. Your new balance is $" + accountBalance);
    }

    public void withdrawFunds(double withdrawalAmount){
        if(accountBalance - withdrawalAmount < 0){
            System.out.println("insufficient funds! You only have $" + accountBalance + " in your account");
        }else{
            accountBalance -= withdrawalAmount;
            System.out.println("Withdraw of this $" + withdrawalAmount + " processed, Remaining balance  = $" + accountBalance);
        }
    }
}
