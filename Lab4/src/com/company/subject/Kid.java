package com.company.subject;

import com.company.util.ObjectInterface;
import com.company.util.View;


//локальный класс стол(в методе где он оставляет записку) выполнил

public class Kid extends Person implements ObjectInterface {
    public String name;
    private boolean need;
    private boolean home;
    private final View TYPE = View.PREOCCUPIED;

    public Kid() {
        super(true, true);
        name = "Малыш";
        need = true;
        home = false;
        mantype();
        joinstory();
    }

    public Kid(String name, boolean need, boolean home) {
        super(true, true);
        this.name = name;
        this.need = need;
        this.home = home;
        mantype();
        joinstory();
    }

    public String mantype() {
        return "Мальчик 7 лет";
    }

    public void say() {
        System.out.println("'" + name + "'" + " отвечает:" + answer());
    }

    public String answer() {
        if (need) {
            return "'Потому, что я хотел ехать один'";
        } else {
            return "'Потому, что я не хотел ехать один'";
        }
    }


    @Override
    public void joinstory() {
        System.out.println(mantype() + "'" + name + "' присоединяется к истории");
    }

    public void needgo(Carlson carlson, Roof roof) {
        System.out.println("'" + name + "'" + " хочет отправится на крышу с '" + carlson.name + "'" + " на '" + roof.name + "'");
    }

    public void inhome(Note note) {
        if (home) {
            System.out.println("Если он будет дома то '" + note.name + "' писать не надо");
        } else {
            System.out.println("А если обнаружится, что его нет дома, он сможет оправдвтся тем, что написал '" + note.name + "'");
        }
    }


    public void considered(Exit exit) {
        System.out.println("'" + name + "' не считал, что сбросить его вниз - наилучший " + exit.name);
        if (TYPE == View.HAPPY) {
            System.out.println("И вид у него стал счастливым");
        } else if (TYPE == View.PREOCCUPIED) {
            System.out.println("И вид у него стал озабоченным");
        } else if (TYPE == View.SLEEPY) {
            System.out.println("И вид у него стал сонным");
        } else if (TYPE == View.TIRED) {
            System.out.println("И вид у него стал уставшим");
        }
    }

    public void ask() {
        System.out.println("- А если откажет? Ведь тогда мы упадем");
    }

    public void think() {
        System.out.println("'" + name + "' подумал и тоже решил, " + cprase);
    }

    public void wrote(Note note) {
        Family family = new Family();
        System.out.println("'" + name + "' написал на клочке бумаги '" + note.name + "' ");
        System.out.println("Кому: " + "'" + family.mothermethod() + "'" + " и " + "'" + family.fathermethod() + "'");
    }

    public void left(Note n) {
        class Table implements ObjectInterface {
            final String name;

            public Table() {
                name = "Стол";
                joinstory();
            }

            @Override
            public void joinstory() {
                System.out.println("'" + name + "' присоединился к итсории");
            }
        }
        Table table = new Table();
        System.out.println("и оставил ее на '" + table.name + "е'");
        System.out.println(n.inscription);
    }

    public void analyze(Family family, Note note) {
        System.out.println("Лучше что бы '" + family.name + "' не нашли '" + note.name + "' до возвращения");
    }

    public String stayed() {
        Family.Grandmother gm = new Family.Grandmother();
        return "Гостил у '" + gm.name + "'";
    }

    public void climb(Carlson cl) {
        Carlson.Shoulders sh = new Carlson.Shoulders();
        System.out.println("'" + name + "' залез '" + cl.name + "у' на '" + sh.name + "'");
    }

    public String afraid(boolean b) {
        if (b) {
            return "боялся";
        } else {
            return "не боялся";
        }
    }

    @Override
    public String toString() {
        return "Персонаж " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kid kid = (Kid) o;
        return name.equals(kid.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
