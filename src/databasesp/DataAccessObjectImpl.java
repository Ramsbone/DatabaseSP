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
public class DataAccessObjectImpl implements DataAccessObject {
    
    	// Team
        @Override
	public ArrayList<User> getTeamMembers(int team_id) {
            ArrayList<User> teamMembers = null;
            
            return teamMembers;
        }
        
        @Override 
	public ArrayList<Team> getTeams(){
             ArrayList<Team> teams = null;
            
            return teams;           
        }
        
        @Override
	public Team getTeam(int id){
             Team team = null;
             
             return team;
        }
        
	// User
        @Override
	public ArrayList<User> getUsers(){
            ArrayList<User> Users = null;
            
            return Users;
        }
        
        @Override
	public User getUser(int id){
            User user = null;
            
            return user;
        }
      
    
}
