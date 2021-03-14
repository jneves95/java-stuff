package com.company;

/*
Encapsulation:

Say that another class creates an instant of our Account class and changes it's balance like this:
    var account = new Account();
    account.balance = -1;

Do we allow our balance to be negative? Should we allow other classes to change the state of our class like this? No, that's why we need encapsulation.
By making our variables private, we restrict its access from outside of the class.
 */
public class Account {
    // public float balance;
    private float balance;


    public void deposit(float amount) {
        if (amount > 0)
            balance += amount;
    }

    public void withdraw(float amount) {
        if (amount > 0)
            balance -= amount;
    }

    public void setBalance(float balance) {
        if (balance >= 0)
            this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }
}
