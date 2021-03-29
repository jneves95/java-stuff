package com.company.abstractfactory;

public class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Quietly and delicately sitting on a gold-plated oak chair.");
    }
}
