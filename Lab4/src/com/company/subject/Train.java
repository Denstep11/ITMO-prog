package com.company.subject;

import com.company.util.ObjectInterface;

public class Train implements ObjectInterface {
    public String name;

    public Train() {
        name = "Поезд";
        joinstory();
    }

    @Override
    public void joinstory() {
        System.out.println(" '" + name + "' присоединился к итсории");
    }
}
