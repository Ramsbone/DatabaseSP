/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.util.ArrayList;

public class Team {
    
    private String name;
    private ArrayList<User> members;

    public Team(String name, ArrayList<User> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", users=" + members + '}';
    }
    
    
}
