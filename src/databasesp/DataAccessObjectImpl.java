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

    private DBConnector conn = null;
    
    public DataAccessObjectImpl() {
        try { 
            this.conn = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Team
    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        ArrayList<User> teamMembers = null;
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "select * from user where user_id in ( select user_id from team_member where team_id = " + team_id + ")";
    
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teamMembers;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = null;
        try {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from team";
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }

    @Override
    public Team getTeam(int team_id) {
        Team team = null;
        try {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user where user_id in ( select user_id from team_member where team_id = " + team_id + ")";
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return team;
    }

    // User
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> Users = null;
        try {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Users;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user where user_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

}
