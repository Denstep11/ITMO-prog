package com.company.subject;

import com.company.util.ObjectInterface;

//создать статический вложенный класс мотор

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

    public void hope(All all, Motor motor) {
        System.out.println("Но пожалуй '" + all.name + "' обойдется благополучно");
        System.out.println("Лишь бы '" + motor.name + "' не отказал");
    }

    public void answer() {
        System.out.println("- Безусловно упадем, но это пусятки, " + cprase);
    }

    public String mantype() {
        return "Мужчина в полном расцвете сил";
    }


    public void ready() {
        System.out.println("'" + name + "' был готов к полёту");
    }

    public void pressed() {
        System.out.println("'" + name + "' нажал кнопку на животе");
    }

    public void landing(boolean goodfly) throws LandingException {
        Roof croof = new Roof();
        croof.name = "своей крыше";
        if (goodfly) {
            System.out.println("Наконец '" + name + "' приземлился на '" + croof.name + "'");
        } else {
            throw new LandingException("И камнем вниз с крыше дома (проверьте успешность полета, главные герои не могут умереть)");
        }
    }

    public static class Shoulders implements ObjectInterface {
        public final String name;

        public Shoulders() {
            name = "Плечи";
            joinstory();
        }

        @Override
        public void joinstory() {
            System.out.println("'" + name + "' присоединился к итсории");
        }
    }

    public void lastphrase() {
        System.out.println("-Мы сейчас взлетим сказал '" + name + "'");
    }

    public void fly(Motor motor) {
        System.out.println("'" + name + "' сделал круг над ближайшей кришей, что бы испытать '" + motor.name + "'");
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