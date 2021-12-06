package com.company.subject;

import com.company.util.ObjectInterface;

public class Motor implements ObjectInterface {
    public String name;
    public boolean work;

    public Motor(boolean work) {
        this.work = work;
        name = "Мотор";
        joinstory();
    }

    public void working() throws MotorException {
        if (Math.random() < 0.5) {
            work = false;
        } else {
            work = true;
        }
        System.out.println("Попытка завести мотор");
        if (work) {
            System.out.println("'" + name + "' загудел");
        } else {
            throw new MotorException("Мотор не работает, попробуйте завести его снова");
        }
    }//теперь нуэно обработать это дело в main

    public void rattle(Kid kid) {
        System.out.println("'" + name + "' тарахтел так равно так нежно, что '" + kid.name + "' " + kid.afraid(false));
    }

    @Override
    public void joinstory() {
        System.out.println("'" + name + "' присоединился к итсории");
    }
}
