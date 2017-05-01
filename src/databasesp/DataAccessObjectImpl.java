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
    private Statement stmt = null;
    private ResultSet rs = null;

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
        ArrayList<User> teamMembers = new ArrayList<User>();
        User user = null;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from user where user_id in ( select user_id from team_member where team_id = " + team_id + ")";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = null;
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");
                user = new User(id, username, password, admin);
                teamMembers.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamMembers;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();
        Team team;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from team";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                team = null;
                ArrayList<User> users = new ArrayList<User>();
                int id = rs.getInt("team_id");
                String teamname = rs.getString("teamname");
                users = getTeamMembers(id);
                team = new Team(teamname, users);
                teams.add(team);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }

    @Override
    public Team getTeam(int team_id) {
        Team team = null;
        ArrayList<User> users = new ArrayList<User>();
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from team where team_id = " + team_id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("team_id");
                String teamname = rs.getString("teamname");
                users = getTeamMembers(id);
                team = new Team(teamname, users);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return team;
    }

    // User
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user = null;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = null;
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");
                user = new User(id, username, password, admin);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public User getUser(int user_id) {
        User user = null;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from user where user_id = " + user_id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");
                user = new User(id, username, password, admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public DBConnector getConn() {
        return conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }
    
    
    

}
