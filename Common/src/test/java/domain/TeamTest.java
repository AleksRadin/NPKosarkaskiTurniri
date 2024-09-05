package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    private Team team;

    @BeforeEach
    void setUp() throws Exception {
        team = new Team();
    }

    @AfterEach
    void tearDown() throws Exception {
        team = null;
    }

    @Test
    void testSetId() {
        team.setId(1L);
        assertEquals(1L, team.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> team.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> team.setId(0L));
    }

    @Test
    void testSetName() {
        team.setName("Test Team");
        assertEquals("Test Team", team.getName());
    }

    @Test
    void testSetNameNull() {
        assertThrows(IllegalArgumentException.class, () -> team.setName(null));
    }

    @Test
    void testSetNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> team.setName(" "));
    }

    @Test
    void testSetCity() {
        team.setCity("Test City");
        assertEquals("Test City", team.getCity());
    }

    @Test
    void testSetCityNull() {
        assertThrows(IllegalArgumentException.class, () -> team.setCity(null));
    }

    @Test
    void testSetCityEmpty() {
        assertThrows(IllegalArgumentException.class, () -> team.setCity(" "));
    }

    @Test
    void testSetCountry() {
        team.setCountry("Test Country");
        assertEquals("Test Country", team.getCountry());
    }

    @Test
    void testSetCountryNull() {
        assertThrows(IllegalArgumentException.class, () -> team.setCountry(null));
    }

    @Test
    void testSetCountryEmpty() {
        assertThrows(IllegalArgumentException.class, () -> team.setCountry(" "));
    }

    @Test
    void testSetFoundedIn() {
        team.setFoundedIn(2000);
        assertEquals(2000, team.getFoundedIn());
    }

    @Test
    void testSetFoundedInNegative() {
        assertThrows(IllegalArgumentException.class, () -> team.setFoundedIn(-1));
    }

    @Test
    void testSetFoundedInZero() {
        assertThrows(IllegalArgumentException.class, () -> team.setFoundedIn(0));
    }

    @Test
    void testSetPlayers() {
        List<Player> players = new ArrayList<>();
        team.setPlayers(players);
        assertEquals(players, team.getPlayers());
    }

    @Test
    void testSetPlayersNull() {
        assertThrows(NullPointerException.class, () -> team.setPlayers(null));
    }

    @Test
    void testToString() {
        team.setName("Test Team");
        team.setCity("Test City");
        team.setCountry("Test Country");
        String result = team.toString();
        assertTrue(result.contains("Test Team"));
        assertTrue(result.contains("Test City"));
        assertTrue(result.contains("Test Country"));
    }

    @Test
    void testEquals() {
        Team team1 = new Team();
        team1.setId(1L);
        Team team2 = new Team();
        team2.setId(1L);
        Team team3 = new Team();
        team3.setId(2L);

        assertTrue(team1.equals(team2));
        assertFalse(team1.equals(team3));
        assertFalse(team1.equals(null));
        assertFalse(team1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        Team team1 = new Team();
        team1.setId(1L);
        Team team2 = new Team();
        team2.setId(1L);
        Team team3 = new Team();
        team3.setId(2L);

        assertEquals(team1.hashCode(), team2.hashCode());
        assertNotEquals(team1.hashCode(), team3.hashCode());
    }
}
