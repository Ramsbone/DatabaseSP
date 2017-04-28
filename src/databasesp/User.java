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

    private int id;
    private String username;
    private String password;
    boolean admin;

    public User(int id, String username, String password, int admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = (admin == 1) ? true : false;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + id + ", name=" + username + ", password=" + password + ", admin=" + admin + '}';
    }

    
    
}
