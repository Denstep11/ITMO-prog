package com.company.subject;

import com.company.util.ObjectInterface;
import com.company.util.WhatHeWrote;

public class Note implements ObjectInterface {
    public String name;
    public String inscription;
    private final WhatHeWrote TYPE = WhatHeWrote.NOTE;

    public Note() {
        name = "Записка";
        inscription = "Я на вирху у Калсона который живет на крыше";
        joinstory();
    }

    public Note(String name) {
        this.name = name;
        inscription = "Я на вирху у Калсона который живет на крыше";
        joinstory();
    }

    @Override
    public void joinstory() {
        System.out.println("'" + name + "' возникла в нашей истории");
    }

    @Override
    public String toString() {
        return "Объект " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return TYPE == note.TYPE;
    }

    @Override
    public int hashCode() {
        return TYPE.hashCode();
    }
}
