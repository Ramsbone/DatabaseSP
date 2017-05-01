/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DataAccessObjectImplTest {

    private static DataAccessObjectImpl dao;
    private static String user1, user2, user3, user4, user5, user6;
    private static String pass1, pass2;
    

    public DataAccessObjectImplTest() {
    }

// Setup
//
// Lidt overflødig/'overkill' BeforeClass setup - men for at anvende den.
    
    @BeforeClass
    public static void setUpClass() {
        
        user1 = "Mickey Mouse";
        user2 = "Fedtmule";
        user3 = "Pluto";
        user4 = "Anders And";
        user5 = "George Gearløs";
        user6 = "Fætter Guf";
        
        pass1 = "5678";
        pass2 = "1234";
        
    }

//
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        dao = new DataAccessObjectImpl();
    }

    @After
    public void tearDown() {
        dao.closeConnection();
    }

    // Test teams
    @Test
    public void testGetTeamMembers() {
        // Positive test
        User user;

        ArrayList<User> teamMembers = dao.getTeamMembers(1);
        assertNotNull(teamMembers);
        assertFalse(teamMembers.isEmpty());
        assertEquals(teamMembers.size(), 3);

        user = teamMembers.get(0);
        assertEquals(user.getId(), 2);
        assertEquals(user.getUsername(), user1);
        assertEquals(user.getPassword(), pass1);
        assertEquals(user.isAdmin(), true);

        user = teamMembers.get(1);
        assertEquals(user.getId(), 3);
        assertEquals(user.getUsername(), user2);
        assertEquals(user.getPassword(), pass2);
        assertEquals(user.isAdmin(), false);

        user = teamMembers.get(2);
        assertEquals(user.getId(), 7);
        assertEquals(user.getUsername(), user3);
        assertEquals(user.getPassword(), pass2);
        assertEquals(user.isAdmin(), false);
    }

    @Test
    public void testGetTeamMembersInValidTeamID() {
        // Negative test
        ArrayList<User> teamMembers = dao.getTeamMembers(99);
        assertNotNull(teamMembers);
        assertTrue(teamMembers.isEmpty());
    }

    @Test
    public void testGetAllTeams() {
        ArrayList<Team> teams = dao.getTeams();
        assertNotNull(teams);
        assertFalse(teams.isEmpty());
        Team team = teams.get(1);
        assertEquals(team.getName(), "B");
        assertEquals(team.getMembers().size(), 5);
    }

    @Test
    public void testGetTeamByID() {
        // positive test
        Team team = dao.getTeam(1);
        assertNotNull(team);
        assertEquals(team.getName(), "A");
        assertEquals(team.getMembers().size(), 3);
    }

    @Test
    public void testGetTeamByInvalidID() {
        // Negative test
        Team team = dao.getTeam(99);
        assertNull(team);
    }

    // Test users
    @Test
    public void testGetAllUsers() {
        User user;

        ArrayList<User> users = dao.getUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(users.size(), 8);

        user = users.get(0);
        assertEquals(user.getId(), 1);
        assertEquals(user.getUsername(), user4);
        assertEquals(user.getPassword(), pass2);
        assertEquals(user.isAdmin(), true);

        user = users.get(3);
        assertEquals(user.getId(), 4);
        assertEquals(user.getUsername(), user5);
        assertEquals(user.getPassword(), pass2);
        assertEquals(user.isAdmin(), false);

        user = users.get(7);
        assertEquals(user.getId(), 8);
        assertEquals(user.getUsername(), user6);
        assertEquals(user.getPassword(), pass2);
        assertEquals(user.isAdmin(), false);
    }

    @Test
    public void testGetUserByID() {
        User user = dao.getUser(2);
        assertEquals(user.getId(), 2);
        assertEquals(user.getUsername(), user1);
        assertEquals(user.getPassword(), pass1);
        assertEquals(user.isAdmin(), true);
    }

    @Test
    public void testGetUserByInvalidID() {
        // Negative test
        User user = dao.getUser(99);
        assertNull(user);

    }

}
