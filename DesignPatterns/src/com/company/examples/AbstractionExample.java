package com.company.examples;

// By making other methods private, we made this class less complex, and we can see that only the 'sendEmail' method is accessible through here,
// which is the only method we need.
public class AbstractionExample {
    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.sendEmail();
    }
}
