package com.company.subject;

import com.company.util.ObjectInterface;

public class All implements ObjectInterface {
    public String name;

    public All(){
        name="всё";
        joinstory();
    }

    @Override
    public void joinstory() {
        System.out.println(" '"+name+"' присоединилось к итсории");
    }
}
