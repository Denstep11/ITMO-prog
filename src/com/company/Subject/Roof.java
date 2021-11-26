package com.company.Subject;

import com.company.Util.ObjectInterface;

public class Roof implements ObjectInterface {
    private String name;

    public Roof() {
        name = "Крыша";
        joinstory();
    }

    public Roof(String name) {
        this.name = name;
        joinstory();
    }

    @Override
    public void joinstory() {
        System.out.println("'" + name + "' возникла в нашей истории");
    }

    @Override
    public String toString() {
        return "Объект " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roof roof = (Roof) o;
        return name.equals(roof.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
