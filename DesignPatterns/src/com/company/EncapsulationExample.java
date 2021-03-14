package com.company;

public class EncapsulationExample {

    public static void main(String[] args) {
        var account = new Account(); // To avoid repeating the class name twice, we can use 'var' instead.
        account.deposit(10);
        account.withdraw(5);
        System.out.println(account.getBalance()); // As you can see, we only use methods of our class to access our account details
    }
}
