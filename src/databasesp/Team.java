/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.util.ArrayList;

/**
 *
 * @author GertLehmann
 */
public class Team {
    
    private String name;
    private ArrayList<User> users;

    public Team(String name, ArrayList<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", users=" + users + '}';
    }
    
    
}
