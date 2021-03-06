/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        ArrayList<User> teamMembers = new ArrayList<User>();
        User user = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from user where user_id in ( select user_id from team_member where team_id = " + team_id + ")";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = null;
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(id, username, password, admin);
                teamMembers.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
        }
        return teamMembers;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();
        Team team;
        Statement stmt = null;
        ResultSet rs = null;
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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
        }
        return teams;
    }

    @Override
    public Team getTeam(int team_id) {
        Team team = null;
        ArrayList<User> users = new ArrayList<User>();
        Statement stmt = null;
        ResultSet rs = null;
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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
        }
        return team;
    }

    // User
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = null;
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(id, username, password, admin);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
        }
        return users;
    }

    @Override
    public User getUser(int user_id) {
        User user = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.getConnection().createStatement();
            String sql = "select * from user where user_id = " + user_id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(id, username, password, admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObjectImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
        }
        return user;
    }

    public DBConnector getConn() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.getConnection().close();
        } catch (SQLException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }

}
