package com.company.subject;

import com.company.util.ObjectInterface;

public class Exit implements ObjectInterface {
    public String name;

    public Exit() {
        name = "Выход";
        joinstory();
    }

    public Exit(String name) {
        this.name = name;
        joinstory();
    }

    public void joinstory() {
        System.out.println("'" + name + "' возникла в нашей истории");
    }

}
