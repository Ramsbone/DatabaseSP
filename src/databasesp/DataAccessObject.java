/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.util.ArrayList;

public interface DataAccessObject {
	// Team
	public ArrayList<User> getTeamMembers(int team_id);
	public ArrayList<Team> getTeams();
	public Team getTeam(int team_id);
	// User
	public ArrayList<User> getUsers();
	public User getUser(int id);
}
