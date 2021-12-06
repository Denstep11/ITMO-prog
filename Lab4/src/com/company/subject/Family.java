package com.company.subject;

import com.company.util.ObjectInterface;

public class Family implements ObjectInterface {
    public String motherphrase = "- Уж если тебе, Малыш, так захотелось поехать на поезде, почему ты мне не сказал об этом?";
    public String name = "Родные";

    public Family() {
        joinstory();
    }

    public String mothermethod() {
        Mother mother = new Mother();
        return mother.name;
    }

    public String fathermethod() {
        Father father = new Father();
        return father.name;
    }


    public static class Grandmother implements ObjectInterface {
        public final String name;

        public Grandmother() {
            name = "Бабушка";
            joinstory();
        }

        @Override
        public void joinstory() {
            System.out.println(" '" + name + "' присоединилась к истории");
        }
    }

    public class Mother implements ObjectInterface {
        public String name;

        public Mother() {
            name = "Мама";
            joinstory();
        }

        @Override
        public void joinstory() {
            System.out.println(" '" + name + "' присоединилась к истории");
        }
    }

    public class Father implements ObjectInterface {
        public String name;

        public Father() {
            name = "Папа";
            joinstory();
        }

        @Override
        public void joinstory() {
            System.out.println(" '" + name + "' присоединился к истории");
        }
    }

    @Override
    public void joinstory() {
        System.out.println(" '" + name + "' присоединились к истории");
    }
}
