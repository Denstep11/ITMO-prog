package com.company;

import com.company.subject.*;

public class Main {

    public static void main(String[] args) {
        Kid kid = new Kid();
        Exit exit = new Exit();
        kid.considered(exit);
        Carlson carlson = new Carlson();
        Motor motor = new Motor(false);
        All all = new All();
        carlson.hope(all, motor);
        kid.ask();
        carlson.answer();
        kid.think();
        Note note = new Note();
        kid.wrote(note);
        kid.left(note);
        Family family = new Family();
        kid.analyze(family, note);
        Train train = new Train();
        OldStory oldStory = new OldStory(kid, train);
        oldStory.then(family);
        kid.say();
        Roof roof = new Roof();
        kid.needgo(carlson, roof);
        kid.inhome(note);
        carlson.ready();
        carlson.pressed();
        try {
            motor.working();
        } catch (MotorException e) {
            System.out.println("Мотор не завелся, новая попытка(но перед этим нужно съесть банку варенья)");
            motor.work = true;
            System.out.println("'" + motor.name + "' загудел");
        }
        kid.climb(carlson);
        carlson.fly(motor);
        motor.rattle(kid);
        Roof croof = new Roof() {
            public final String name = "Крыша Карлсона";

            @Override
            public void joinstory() {
                System.out.println(name + " возникла в нашей истории");
            }
        };
        carlson.landing(true);
    }
}
