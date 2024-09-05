package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeagueTest {

    private League league;

    @BeforeEach
    void setUp() throws Exception {
        league = new League();
    }

    @AfterEach
    void tearDown() throws Exception {
        league = null;
    }

    @Test
    void testSetId() {
        league.setId(1L);
        assertEquals(1L, league.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> league.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> league.setId(0L));
    }

    @Test
    void testSetName() {
        league.setName("Premier League");
        assertEquals("Premier League", league.getName());
    }

    @Test
    void testSetNameNull() {
        assertThrows(NullPointerException.class, () -> league.setName(null));
    }

    @Test
    void testSetNameEmpty() {
        assertThrows(NullPointerException.class, () -> league.setName(""));
    }

    @Test
    void testSetSeason() {
        league.setSeason("2024");
        assertEquals("2024", league.getSeason());
    }

    @Test
    void testSetSeasonNull() {
        assertThrows(NullPointerException.class, () -> league.setSeason(null));
    }

    @Test
    void testSetSeasonEmpty() {
        assertThrows(NullPointerException.class, () -> league.setSeason(""));
    }

    @Test
    void testToString() {
        league.setName("Premier League");
        String result = league.toString();
        assertEquals("Premier League", result);
    }

    @Test
    void testEquals() {
        League league1 = new League();
        league1.setId(1L);
        league1.setName("Premier League");
        league1.setSeason("2024");

        League league2 = new League();
        league2.setId(1L);
        league2.setName("Premier League");
        league2.setSeason("2024");

        League league3 = new League();
        league3.setId(2L);
        league3.setName("La Liga");
        league3.setSeason("2024");

        assertTrue(league1.equals(league2));
        assertFalse(league1.equals(league3));
        assertFalse(league1.equals(null));
        assertFalse(league1.equals(new Object()));
    }

    @Test
    void testHashCode() {
        League league1 = new League();
        league1.setId(1L);
        league1.setName("Premier League");
        league1.setSeason("2024");

        League league2 = new League();
        league2.setId(1L);
        league2.setName("Premier League");
        league2.setSeason("2024");

        League league3 = new League();
        league3.setId(2L);
        league3.setName("La Liga");
        league3.setSeason("2024");

        assertEquals(league1.hashCode(), league2.hashCode());
        assertNotEquals(league1.hashCode(), league3.hashCode());
    }
}
