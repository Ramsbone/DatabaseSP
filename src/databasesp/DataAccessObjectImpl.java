/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GertLehmann
 */
public class DataAccessObjectImpl implements DataAccessObject {

    private final DBConnector conn;

    public DataAccessObjectImpl() throws Exception {
        this.conn = new DBConnector();
    }

    // Team
    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        ArrayList<User> teamMembers = null;


        return teamMembers;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = null;

        return teams;
    }

    @Override
    public Team getTeam(int team_id) {
        Team team = null;

        return team;
    }

    // User
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user = null;
        try {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = null;
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");
                user = new User(id, username, password, admin);
                System.out.println(user.toString());
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public User getUser(int user_id) {
        User user = null;
        try {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user where user_id = " + user_id;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");
                user = new User(id, username, password, admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
