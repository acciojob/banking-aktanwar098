package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        setMaxWithdrawalLimit(maxWithdrawalLimit);
        setRate(rate);

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        double bal=getBalance();
        if(maxWithdrawalLimit<amount) throw new Exception("Maximum Withdraw Limit Exceed");
        if(bal<amount) throw new Exception("Insufficient Balance");

        else{
            bal=bal-amount;
            setBalance(bal);
            setMaxWithdrawalLimit(maxWithdrawalLimit-amount);
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        double balance=getBalance();
        double totalAmount=balance*(1+(this.rate*years));
        totalAmount=totalAmount/100;
        return totalAmount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double bal=getBalance();
        double compoundedAmount=bal*(Math.pow((1+rate/times),times*years));
        return compoundedAmount;
    }

}
