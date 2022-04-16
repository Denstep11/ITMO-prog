package util;

import data.HumanBeing;

import java.util.Comparator;

/**
 * set the collection sorting method
 */
public class CompareHuman implements Comparator<HumanBeing> {
    @Override
    public int compare(HumanBeing o1, HumanBeing o2) {
        return (o1.getName().compareTo(o2.getName()));
    }
}
