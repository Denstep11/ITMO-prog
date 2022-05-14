package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usercheck {
    private String login;
    private String password;
    private String answer = "";
    boolean rightpl = false;

    public Usercheck(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String check() {
        try {
            ResultSet res = Updatedb.statement.executeQuery("SELECT * FROM users\n" +
                    "WHERE login = " + "'" + login + "'" + ";");
            while (res.next()) {
                if (res.getString(2).equals(password)) {
                    rightpl = true;
                    break;
                }
            }
            if (rightpl) {
                answer = "true";
            } else {
                answer = "false";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public String adduser() {
        PreparedStatement ps;
        try {
            rightpl = true;
            ResultSet res = Updatedb.statement.executeQuery("SELECT * FROM users");
            Updatedb.lk.readLock().lock();
            while (res.next()) {
                if (res.getString(1).equals(login)) {
                    rightpl = false;
                    break;
                } else {
                    rightpl = true;
                }
            }
            Updatedb.lk.readLock().unlock();
            Updatedb.lk.writeLock().lock();
                if (rightpl){
                    ps = Updatedb.conn.prepareStatement("INSERT INTO users VALUES (?,?);");
                    ps.setString(1, login);
                    ps.setString(2, password);
                    int bd = ps.executeUpdate();
                    if (bd > 0) {
                        answer = "true";
                    } else {
                        answer = "false";
                    }
                }
                else {
                    answer="false";
                }
                Updatedb.lk.writeLock().unlock();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return answer;
    }
}
