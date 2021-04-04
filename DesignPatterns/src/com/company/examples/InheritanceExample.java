package com.company.examples;

/*
Say we wanted to create a GUI - we would need elements like TextBox, Button, CheckBox, and these elements should have some common behavior like 'enable', 'focus', 'setPosition', and so on.
Now we wouldn't want to implement these behaviors for every single class we create. We should implement all these common behaviors in a base class, and have all our elements inherit these behaviors.
 */

public class InheritanceExample {
    public static void main(String[] args) {
        var textBox = new TextBox();
        textBox.enable();

        drawUIControl(textBox);
    }

    public static void drawUIControl(UIControl control) {
        // As we can see, in this method we are working with a 'UIControl' object, but in run-time, this object can take many forms
        // This is polymorphism in action
        control.draw();
    }
}
