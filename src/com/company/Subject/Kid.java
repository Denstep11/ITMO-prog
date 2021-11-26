package com.company.Subject;

import com.company.Util.ObjectInterface;

public class Kid extends Person implements ObjectInterface {
    private String name;
    private boolean need;
    private boolean home;

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
        System.out.println(mantype() + " '" + name + "' присоединяется к истории");
    }

    public void needgo(Carlson carlson) {
        System.out.println(name + " хочет отправится на крышу с " + carlson.name);
    }

    public void inhome(Note note) {
        if (home) {
            System.out.println("Если он будет дома то '" + note.name + "' писать не надо");
        } else {
            System.out.println("А если обнаружится, что его нет дома, он сможет оправдвтся тем, что написал " + note.name);
        }
    }

    @Override
    public String toString() {
        return "Персонаж "+name;
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
