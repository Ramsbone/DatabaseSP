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
public class DatabaseSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataAccessObjectImpl dao = null;
        try {
            dao = new DataAccessObjectImpl();

            System.out.println("--------------------------------------------");

            System.out.println("getTeamMembers metode (team #1): ");
            ArrayList<User> teamMembers = dao.getTeamMembers(1);
            for (User teamMember : teamMembers) {
                System.out.println(teamMember.toString());
            }

            System.out.println("--------------------------------------------");
            System.out.println("getTeam metode (team #3):");
            Team showTeam = dao.getTeam(3);
            System.out.println("Team = " + showTeam.getName());
            for (User teamMember : showTeam.getMembers()) {
                System.out.println(teamMember.toString());
            }

            System.out.println("--------------------------------------------");
            System.out.println("getUser metode (user #7):");
            User showUser = dao.getUser(7);
            System.out.println(showUser.toString());
            System.out.println("--------------------------------------------");

        } catch (Exception ex) {
            ex.printStackTrace();
            // http://stackoverflow.com/questions/2225221/closing-database-connections-in-java
            /*
            close:
                ResultSet rs = null;
                PreparedStatement ps = null;
                Connection conn = null;
            in that order.
             */
        }finally {
            if (dao.getRs() != null) {
                try {
                    dao.getRs().close();
                } catch (Exception e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (dao.getStmt() != null) {
                try {
                    dao.getStmt().close();
                } catch (Exception e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
            if (dao.getConn().getConnection() != null) {
                try {
                    dao.getConn().getConnection().close();
                } catch (Exception e) {
                    System.out.println("Exception thrown  :" + e);
                }
            }
        }
        //forbindelsen burde være lukket:
        /*
        try{
            System.out.println("--------------------------------------------");

            System.out.println("getTeamMembers metode (team #1): ");
            ArrayList<User> teamMembers = dao.getTeamMembers(1);
            for (User teamMember : teamMembers) {
                System.out.println(teamMember.toString());
            }
        }catch(Exception e){
            System.out.println("Min forbindelse er lukket: " + e);
        }
        */
    }
}
