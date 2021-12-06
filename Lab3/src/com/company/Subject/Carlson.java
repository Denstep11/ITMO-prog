package com.company.Subject;

import com.company.Util.ObjectInterface;

public class Carlson extends Person implements ObjectInterface {
    public String name;

    public Carlson() {
        super(true, false);
        name = "Карлсон";
        mantype();
        joinstory();
    }

    public Carlson(String name) {
        super(true, false);
        this.name = name;
        mantype();
        joinstory();
    }

    public String mantype() {
        return "Мужчина в полном расцвете сил";
    }

    @Override
    public void joinstory() {
        System.out.println(mantype() + " '" + name + "' присоединяется к истории");
    }

    @Override
    public String toString() {
        return "Персонаж " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carlson carlson = (Carlson) o;
        return name.equals(carlson.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}