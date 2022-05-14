package util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Updatedb {
    public static Statement statement;
    public static Connection conn;
    public static ReadWriteLock lk = new ReentrantReadWriteLock();
}
