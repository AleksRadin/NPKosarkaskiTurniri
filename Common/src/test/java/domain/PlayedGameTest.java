package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayedGameTest {

    private Team homeTeam1;
    private Team awayTeam1;
    private Game game1;
    private int homeTeamPoints1;
    private int awayTeamPoints1;

    private Team homeTeam2;
    private Team awayTeam2;
    private Game game2;
    private int homeTeamPoints2;
    private int awayTeamPoints2;

    private PlayedGame playedGame1;
    private PlayedGame playedGame2;

    @BeforeEach
    void setUp() {
        homeTeam1 = new Team();
        awayTeam1 = new Team();
        game1 = new Game();
        homeTeamPoints1 = 1;
        awayTeamPoints1 = 2;

        homeTeam2 = new Team();
        awayTeam2 = new Team();
        game2 = new Game();
        homeTeamPoints2 = 3;
        awayTeamPoints2 = 4;

        playedGame1 = new PlayedGame(homeTeam1, awayTeam1, game1, homeTeamPoints1, awayTeamPoints1);
        playedGame2 = new PlayedGame(homeTeam2, awayTeam2, game2, homeTeamPoints2, awayTeamPoints2);
    }

    @Test
    void testSetHomeTeam() {
        playedGame1.setHomeTeam(homeTeam2);
        assertEquals(homeTeam2, playedGame1.getHomeTeam());
    }

    @Test
    void testSetHomeTeamNull() {
        assertThrows(NullPointerException.class, () -> playedGame1.setHomeTeam(null));
    }

    @Test
    void testSetAwayTeam() {
        playedGame1.setAwayTeam(awayTeam2);
        assertEquals(awayTeam2, playedGame1.getAwayTeam());
    }

    @Test
    void testSetAwayTeamNull() {
        assertThrows(NullPointerException.class, () -> playedGame1.setAwayTeam(null));
    }

    @Test
    void testSetGame() {
        playedGame1.setGame(game2);
        assertEquals(game2, playedGame1.getGame());
    }

    @Test
    void testSetGameNull() {
        assertThrows(NullPointerException.class, () -> playedGame1.setGame(null));
    }

    @Test
    void testSetHomeTeamPoints() {
        playedGame1.setHomeTeamPoints(5);
        assertEquals(5, playedGame1.getHomeTeamPoints());
    }

    @Test
    void testSetHomeTeamPointsNegative() {
        assertThrows(IllegalArgumentException.class, () -> playedGame1.setHomeTeamPoints(-1));
    }

    @Test
    void testSetAwayTeamPoints() {
        playedGame1.setAwayTeamPoints(6);
        assertEquals(6, playedGame1.getAwayTeamPoints());
    }

    @Test
    void testSetAwayTeamPointsNegative() {
        assertThrows(IllegalArgumentException.class, () -> playedGame1.setAwayTeamPoints(-1));
    }

    @Test
    void testToString() {
        String expected = "PlayedGame{" +
                "homeTeam=" + homeTeam1 +
                ", awayTeam=" + awayTeam1 +
                ", game=" + game1 +
                ", homeTeamPoints=" + homeTeamPoints1 +
                ", awayTeamPoints=" + awayTeamPoints1 +
                '}';
        
        String result = playedGame1.toString();

        assertEquals(expected, result);
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(playedGame1.equals(playedGame1));
    }

    @Test
    void testEqualsDifferentObjectsSameValues() {
        playedGame2 = new PlayedGame(homeTeam1, awayTeam1, game1, homeTeamPoints1, awayTeamPoints1);
        assertTrue(playedGame1.equals(playedGame2));
    }

    @Test
    void testEqualsDifferentObjectsDifferentValues() {
        playedGame2 = new PlayedGame(homeTeam2, awayTeam2, game2, homeTeamPoints2, awayTeamPoints2);
        assertFalse(playedGame1.equals(playedGame2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(playedGame1.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(playedGame1.equals(new Object()));
    }
}
