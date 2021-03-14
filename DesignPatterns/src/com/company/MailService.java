package com.company;

/*
Abstraction:
Reduce complexity by hiding away unnecessary details. For example: when sending an email, we don't care what it does in the process of sending an email, we just want the email sent.
So in this example, our methods 'connect', 'disconnect', and 'authenticate' only add complexity to our class, we don't want it to be accessible to our main program.
By making the methods private, we abstract their implementation.
 */
public class MailService {
    public void sendEmail() {
        connect();
        authenticate();
        // send email
        disconnect();
    }

    private void connect() {
        System.out.println("Connect");
    }

    private void disconnect() {
        System.out.println("Disconnect");
    }

    private void authenticate() {
        System.out.println("Authenticate");
    }
}
