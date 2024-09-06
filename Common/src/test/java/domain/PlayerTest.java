package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import player.state.PlayerState;

public class PlayerTest {

    private Player player;
    private Team team;

    @BeforeEach
    void setUp() throws Exception {
        team = new Team();
        team.setId(1L);
        player = new Player();
    }

    @AfterEach
    void tearDown() throws Exception {
        player = null;
        team = null;
    }

    @Test
    void testSetId() {
        player.setId(5L);
        assertEquals(5L, player.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> player.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> player.setId(0L));
    }

    @Test
    void testSetFirstname() {
        player.setFirstname("John");
        assertEquals("John", player.getFirstname());
    }

    @Test
    void testSetFirstnameNull() {
        assertThrows(NullPointerException.class, () -> player.setFirstname(null));
    }

    @Test
    void testSetLastname() {
        player.setLastname("Doe");
        assertEquals("Doe", player.getLastname());
    }

    @Test
    void testSetLastnameNull() {
        assertThrows(NullPointerException.class, () -> player.setLastname(null));
    }

    @Test
    void testSetBirthday() {
        LocalDate birthday = LocalDate.of(1990, 1, 1);
        player.setBirthday(birthday);
        assertEquals(birthday, player.getBirthday());
    }

    @Test
    void testSetBirthdayNull() {
        assertThrows(NullPointerException.class, () -> player.setBirthday(null));
    }

    @Test
    void testSetBirthdayFuture() {
        assertThrows(IllegalArgumentException.class, () -> player.setBirthday(LocalDate.of(2100, 1, 1)));
    }

    @Test
    void testSetPosition() {
        player.setPosition("Forward");
        assertEquals("Forward", player.getPosition());
    }

    @Test
    void testSetPositionNull() {
        assertThrows(NullPointerException.class, () -> player.setPosition(null));
    }

    @Test
    void testSetHeight() {
        player.setHeight(180.5);
        assertEquals(180.5, player.getHeight());
    }

    @Test
    void testSetHeightNegative() {
        assertThrows(IllegalArgumentException.class, () -> player.setHeight(-1.0));
    }

    @Test
    void testSetWeight() {
        player.setWeight(75.0);
        assertEquals(75.0, player.getWeight());
    }

    @Test
    void testSetWeightNegative() {
        assertThrows(IllegalArgumentException.class, () -> player.setWeight(-1.0));
    }

    @Test
    void testSetTeam() {
        player.setTeam(team);
        assertEquals(team, player.getTeam());
    }

    @Test
    void testSetTeamNull() {
        assertThrows(NullPointerException.class, () -> player.setTeam(null));
    }

    @Test
    void testSetState() {
        PlayerState state = PlayerState.ADDED;
        player.setState(state);
        assertEquals(state, player.getState());
    }

    @Test
    void testSetStateNull() {
        assertThrows(NullPointerException.class, () -> player.setState(null));
    }

    @Test
    void testToString() {
        player.setFirstname("John");
        player.setLastname("Doe");
        player.setPosition("Forward");
        String result = player.toString();
        assertTrue(result.contains("John Doe - Forward"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 1, 1, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 1, true",
        "1, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 2, 1, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 2, true",
        "1, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 1, 2, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 2, false",
        "1, John, Doe, 1990-01-01, Forward, 180.0, 75.0, 1, 1, Jane, Doe, 1990-01-01, Forward, 180.0, 75.0, 1, false"
    })
    void testEqualsCsvSource(Long id1, String firstname1, String lastname1, LocalDate birthday1, String position1, 
                             double height1, double weight1, Long teamId1, 
                             Long id2, String firstname2, String lastname2, LocalDate birthday2, String position2, 
                             double height2, double weight2, Long teamId2, boolean expected) {
        Team team1 = new Team();
        team1.setId(teamId1);

        Team team2 = new Team();
        team2.setId(teamId2);

        player.setId(id1);
        player.setFirstname(firstname1);
        player.setLastname(lastname1);
        player.setBirthday(birthday1);
        player.setPosition(position1);
        player.setHeight(height1);
        player.setWeight(weight1);
        player.setTeam(team1);

        Player otherPlayer = new Player();
        otherPlayer.setId(id2);
        otherPlayer.setFirstname(firstname2);
        otherPlayer.setLastname(lastname2);
        otherPlayer.setBirthday(birthday2);
        otherPlayer.setPosition(position2);
        otherPlayer.setHeight(height2);
        otherPlayer.setWeight(weight2);
        otherPlayer.setTeam(team2);

        assertEquals(expected, player.equals(otherPlayer));
    }

    @Test
    void testEqualsNull() {
        assertFalse(player.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(player.equals(player));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(player.equals(new Exception()));
    }
}

