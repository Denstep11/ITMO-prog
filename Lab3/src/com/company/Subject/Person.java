package com.company.Subject;

import com.company.Util.PersonsInterface;

public abstract class Person implements PersonsInterface {

    private boolean man;
    private boolean young;

    public Person(boolean man, boolean young) {
        this.man = man;
        this.young = young;
    }
}
