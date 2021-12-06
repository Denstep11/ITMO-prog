package com.company.Subject;

import com.company.Util.ObjectInterface;
import com.company.Util.WhatHeWrote;

public class Note implements ObjectInterface {
    public String name;
    private final WhatHeWrote TYPE = WhatHeWrote.NOTE;

    public Note() {
        name = "Записка";
        joinstory();
    }

    public Note(String name) {
        this.name = name;
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
