package com.company.subject;

import com.company.util.ObjectInterface;

public class OldStory implements ObjectInterface {
    public String name = "Старая история";

    public OldStory(Kid kid, Train train) {
        joinstory();
        System.out.println("А то может получится так, как уже было однажды");
        System.out.println("'" + kid.name + "' " + kid.stayed() + " и решил сесть на '" + train.name + "' и вернуться домой");
    }

    public void then(Family family) {
        System.out.println("Тогда '" + family.mothermethod() + "' палакла и говорила ему:");
        System.out.println(family.motherphrase);
    }

    @Override
    public void joinstory() {
        System.out.println("'" + name + "' присоединилась к итсории");
    }
}
