package com.company;

import com.company.Subject.*;

public class Main {

    public static void main(String[] args) {
        Kid kid = new Kid();
        kid.say();
        Carlson carlson = new Carlson();
        Roof roof = new Roof();
        kid.needgo(carlson);
        Note note = new Note();
        kid.inhome(note);
    }
}

