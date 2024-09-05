package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

    private Game game;
    private League league;

    @BeforeEach
    void setUp() throws Exception {
        league = new League(); 
        league.setId(1L);
        game = new Game();
        game.setId(1L);
        game.setGameDate(LocalDate.of(2024, 9, 4));
        game.setGameTime(LocalTime.of(15, 30));
        game.setLeague(league);
    }

    @AfterEach
    void tearDown() throws Exception {
        game = null;
        league = null;
    }

    @Test
    void testSetId() {
        game.setId(5L);
        assertEquals(5L, game.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> game.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> game.setId(0L));
    }

    @Test
    void testSetGameDate() {
        LocalDate date = LocalDate.of(2024, 9, 5);
        game.setGameDate(date);
        assertEquals(date, game.getGameDate());
    }

    @Test
    void testSetGameDateNull() {
        assertThrows(NullPointerException.class, () -> game.setGameDate(null));
    }

    @Test
    void testSetGameTime() {
        LocalTime time = LocalTime.of(16, 45);
        game.setGameTime(time);
        assertEquals(time, game.getGameTime());
    }

    @Test
    void testSetGameTimeNull() {
        assertThrows(NullPointerException.class, () -> game.setGameTime(null));
    }

    @Test
    void testSetLeague() {
        League newLeague = new League();
        newLeague.setId(2L);
        game.setLeague(newLeague);
        assertEquals(newLeague, game.getLeague());
    }

    @Test
    void testSetLeagueNull() {
        assertThrows(NullPointerException.class, () -> game.setLeague(null));
    }

    @Test
    void testToString() {
        String result = game.toString();
        assertTrue(result.contains("Game - 1"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2024-09-04, 15:30:00, 1, 1, 2024-09-04, 15:30:00, 1, true",
        "1, 2024-09-04, 15:30:00, 1, 2, 2024-09-04, 15:30:00, 1, false",
        "1, 2024-09-04, 15:30:00, 1, 1, 2024-09-05, 15:30:00, 1, false",
        "1, 2024-09-04, 15:30:00, 1, 1, 2024-09-04, 16:45:00, 1, false",
        "1, 2024-09-04, 15:30:00, 1, 1, 2024-09-04, 15:30:00, 2, false"
    })
    void testEqualsCsvSource(Long id1, LocalDate gameDate1, LocalTime gameTime1, Long leagueId1,
                             Long id2, LocalDate gameDate2, LocalTime gameTime2, Long leagueId2, boolean expected) {
        League league1 = new League();
        league1.setId(leagueId1);

        League league2 = new League();
        league2.setId(leagueId2);

        Game game1 = new Game();
        game1.setId(id1);
        game1.setGameDate(gameDate1);
        game1.setGameTime(gameTime1);
        game1.setLeague(league1);

        Game game2 = new Game();
        game2.setId(id2);
        game2.setGameDate(gameDate2);
        game2.setGameTime(gameTime2);
        game2.setLeague(league2);

        assertEquals(expected, game1.equals(game2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(game.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(game.equals(game));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(game.equals(new Exception()));
    }
}
