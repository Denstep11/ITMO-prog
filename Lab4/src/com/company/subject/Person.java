package com.company.subject;

import com.company.util.PersonsInterface;

public abstract class Person implements PersonsInterface {

    private boolean man;
    private boolean young;
    public String cprase = "дело житейское";

    public Person(boolean man, boolean young) {
        this.man = man;
        this.young = young;
    }
}
