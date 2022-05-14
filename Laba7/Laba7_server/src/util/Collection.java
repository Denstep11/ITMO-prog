package util;

import data.HumanBeing;

import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * keep information about collection
 */
public class Collection {
    public static String createtime;
    public static String modiftime;
    public static Long id= Long.valueOf(0);
    public static TreeSet<HumanBeing> tree;
    public final static String address = "C:\\Users\\denvv\\OneDrive\\Desktop\\test.csv";
}
