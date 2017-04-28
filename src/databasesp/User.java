/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

/**
 *
 * @author GertLehmann
 */
public class User {

    private int userid;
    private String name;
    private String password;
    boolean admin;

    public User(int userid, String name, String password, int admin) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.admin = (admin == 1) ? true : false;
    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", name=" + name + ", password=" + password + ", admin=" + admin + '}';
    }

    
    
}
