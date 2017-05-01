/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.util.ArrayList;

public class DatabaseSP {

    public static void main(String[] args) {
        DataAccessObjectImpl dao = null;

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
        System.out.println("getTeams metode:");
        ArrayList<Team> showTeams = dao.getTeams();
        for (Team team : showTeams) {
            System.out.println(team.toString());
        }

        System.out.println("--------------------------------------------");
        System.out.println("getUser metode (user #7):");
        User showUser = dao.getUser(7);
        System.out.println(showUser.toString());
        System.out.println("--------------------------------------------");

        dao.closeConnection();
    }
}
