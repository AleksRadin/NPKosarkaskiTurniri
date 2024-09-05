package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoachTest {

    private Coach coach;
    private Team team;

    @BeforeEach
    void setUp() throws Exception {
        team = new Team();
        team.setId(1L);
        team.setName("Test Team");
        coach = new Coach();
    }

    @AfterEach
    void tearDown() throws Exception {
        coach = null;
        team = null;
    }

    @Test
    void testSetId() {
        coach.setId(5L);
        assertEquals(5L, coach.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> coach.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> coach.setId(0L));
    }

    @Test
    void testSetFirstname() {
        coach.setFirstname("John");
        assertEquals("John", coach.getFirstname());
    }

    @Test
    void testSetFirstnameNull() {
        assertThrows(NullPointerException.class, () -> coach.setFirstname(null));
    }

    @Test
    void testSetLastname() {
        coach.setLastname("Doe");
        assertEquals("Doe", coach.getLastname());
    }

    @Test
    void testSetLastnameNull() {
        assertThrows(NullPointerException.class, () -> coach.setLastname(null));
    }

    @Test
    void testSetNumbOfChampionships() {
        coach.setNumbOfChampionships(5);
        assertEquals(5, coach.getNumbOfChampionships());
    }

    @Test
    void testSetNumbOfChampionshipsNegative() {
        assertThrows(IllegalArgumentException.class, () -> coach.setNumbOfChampionships(-1));
    }

    @Test
    void testSetTeam() {
        coach.setTeam(team);
        assertEquals(team, coach.getTeam());
    }

    @Test
    void testSetTeamNull() {
        assertThrows(NullPointerException.class, () -> coach.setTeam(null));
    }

    @Test
    void testToString() {
        coach.setFirstname("John");
        coach.setLastname("Doe");
        String result = coach.toString();
        assertTrue(result.contains("John - Doe"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, John, Doe, 5, 1, 1, John, Doe, 5, 1, true",
        "1, John, Doe, 5, 1, 1, John, Doe, 6, 1, false",
        "1, John, Doe, 5, 1, 1, John, Doe, 5, 2, false",
        "1, John, Doe, 5, 1, 1, Jane, Doe, 5, 1, false"
    })
    void testEqualsCsvSource(Long id1, String firstname1, String lastname1, int num1, Long teamId1,
                             Long id2, String firstname2, String lastname2, int num2, Long teamId2, boolean expected) {
        Team team1 = new Team();
        team1.setId(teamId1);

        Team team2 = new Team();
        team2.setId(teamId2);

        coach.setId(id1);
        coach.setFirstname(firstname1);
        coach.setLastname(lastname1);
        coach.setNumbOfChampionships(num1);
        coach.setTeam(team1);

        Coach otherCoach = new Coach();
        otherCoach.setId(id2);
        otherCoach.setFirstname(firstname2);
        otherCoach.setLastname(lastname2);
        otherCoach.setNumbOfChampionships(num2);
        otherCoach.setTeam(team2);

        assertEquals(expected, coach.equals(otherCoach));
    }

    @Test
    void testEqualsNull() {
        assertFalse(coach.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(coach.equals(coach));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(coach.equals(new Exception()));
    }
}
