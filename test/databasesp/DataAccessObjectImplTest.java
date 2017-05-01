/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesp;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GertLehmann
 */
public class DataAccessObjectImplTest {

    private static DataAccessObjectImpl dao;

    public DataAccessObjectImplTest() {
    }

// Setup
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
    @Before
    public void setUp() {
        dao = new DataAccessObjectImpl();
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
        assertEquals(user.getUsername(), "Mickey Mouse");
        assertEquals(user.getPassword(), "5678");
        assertEquals(user.isAdmin(), true);

        user = teamMembers.get(1);
        assertEquals(user.getId(), 3);
        assertEquals(user.getUsername(), "Fedtmule");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);

        user = teamMembers.get(2);
        assertEquals(user.getId(), 7);
        assertEquals(user.getUsername(), "Pluto");
        assertEquals(user.getPassword(), "1234");
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
        Team team = teams.get(0);
        assertEquals(team.getName(), "A");
        assertEquals(team.getMembers().size(), 3);
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
        assertEquals(user.getUsername(), "Anders And");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), true);

        user = users.get(3);
        assertEquals(user.getId(), 4);
        assertEquals(user.getUsername(), "George Gearløs");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);

        user = users.get(7);
        assertEquals(user.getId(), 8);
        assertEquals(user.getUsername(), "Fætter Guf");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);
    }

    @Test
    public void testGetUserByID() {
        User user = dao.getUser(2);
        assertEquals(user.getId(), 2);
        assertEquals(user.getUsername(), "Mickey Mouse");
        assertEquals(user.getPassword(), "5678");
        assertEquals(user.isAdmin(), true);
    }

    @Test
    public void testGetUserByInvalidID() {
        // Negative test
        User user = dao.getUser(99);
        assertNull(user);

    }

    @After
    public void tearDown() {
//        if (dao.getRs() != null) {
//            try {
//                dao.getRs().close();
//            } catch (Exception e) {
//                System.out.println("Exception thrown  :" + e);
//            }
//        }
//        if (dao.getStmt() != null) {
//            try {
//                dao.getStmt().close();
//            } catch (Exception e) {
//                System.out.println("Exception thrown  :" + e);
//            }
//        }
        if (dao.getConn().getConnection() != null) {
            try {
                dao.closeConnection();
            } catch (Exception e) {
                System.out.println("Exception thrown  :" + e);
            }
        }
    }

}
