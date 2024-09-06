package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerStatisticTest {

    private PlayerStatistic playerStatistic;
    private Player player;
    private Game game;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setId(1L);
        game = new Game();
        game.setId(1L);
        playerStatistic = new PlayerStatistic();
    }

    @AfterEach
    void tearDown() {
        playerStatistic = null;
        player = null;
        game = null;
    }

    @Test
    void testSetId() {
        playerStatistic.setId(5L);
        assertEquals(5L, playerStatistic.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> playerStatistic.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setId(0L));
    }

    @Test
    void testSetPlayer() {
        playerStatistic.setPlayer(player);
        assertEquals(player, playerStatistic.getPlayer());
    }

    @Test
    void testSetPlayerNull() {
        assertThrows(NullPointerException.class, () -> playerStatistic.setPlayer(null));
    }

    @Test
    void testSetGame() {
        playerStatistic.setGame(game);
        assertEquals(game, playerStatistic.getGame());
    }

    @Test
    void testSetGameNull() {
        assertThrows(NullPointerException.class, () -> playerStatistic.setGame(null));
    }

    @Test
    void testSetMinutesPlayed() {
        playerStatistic.setMinutesPlayed(30);
        assertEquals(30, playerStatistic.getMinutesPlayed());
    }

    @Test
    void testSetMinutesPlayedNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setMinutesPlayed(-1));
    }

    @Test
    void testSetPointsScored() {
        playerStatistic.setPointsScored(20);
        assertEquals(20, playerStatistic.getPointsScored());
    }

    @Test
    void testSetPointsScoredNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setPointsScored(-1));
    }

    @Test
    void testSetThreePointersMade() {
        playerStatistic.setThreePointersMade(5);
        assertEquals(5, playerStatistic.getThreePointersMade());
    }

    @Test
    void testSetThreePointersMadeNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setThreePointersMade(-1));
    }

    @Test
    void testSetThreePointersAttempted() {
        playerStatistic.setThreePointersAttempted(10);
        assertEquals(10, playerStatistic.getThreePointersAttempted());
    }

    @Test
    void testSetThreePointersAttemptedNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setThreePointersAttempted(-1));
    }

    @Test
    void testSetFreeThrowsMade() {
        playerStatistic.setFreeThrowsMade(7);
        assertEquals(7, playerStatistic.getFreeThrowsMade());
    }

    @Test
    void testSetFreeThrowsMadeNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setFreeThrowsMade(-1));
    }

    @Test
    void testSetFreeThrowsAttempted() {
        playerStatistic.setFreeThrowsAttempted(8);
        assertEquals(8, playerStatistic.getFreeThrowsAttempted());
    }

    @Test
    void testSetFreeThrowsAttemptedNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setFreeThrowsAttempted(-1));
    }

    @Test
    void testSetReboundsOffensive() {
        playerStatistic.setReboundsOffensive(3);
        assertEquals(3, playerStatistic.getReboundsOffensive());
    }

    @Test
    void testSetReboundsOffensiveNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setReboundsOffensive(-1));
    }

    @Test
    void testSetReboundsDefensive() {
        playerStatistic.setReboundsDefensive(4);
        assertEquals(4, playerStatistic.getReboundsDefensive());
    }

    @Test
    void testSetReboundsDefensiveNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setReboundsDefensive(-1));
    }

    @Test
    void testSetAssists() {
        playerStatistic.setAssists(5);
        assertEquals(5, playerStatistic.getAssists());
    }

    @Test
    void testSetAssistsNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setAssists(-1));
    }

    @Test
    void testSetSteals() {
        playerStatistic.setSteals(2);
        assertEquals(2, playerStatistic.getSteals());
    }

    @Test
    void testSetStealsNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setSteals(-1));
    }

    @Test
    void testSetBlocks() {
        playerStatistic.setBlocks(1);
        assertEquals(1, playerStatistic.getBlocks());
    }

    @Test
    void testSetBlocksNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setBlocks(-1));
    }

    @Test
    void testSetPersonalFouls() {
        playerStatistic.setPersonalFouls(3);
        assertEquals(3, playerStatistic.getPersonalFouls());
    }

    @Test
    void testSetPersonalFoulsNegative() {
        assertThrows(IllegalArgumentException.class, () -> playerStatistic.setPersonalFouls(-1));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, 1, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, true",
        "1, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, 2, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, false",
        "1, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, 2, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 4, false",
        "1, 30, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, 1, 25, 20, 5, 10, 7, 8, 3, 4, 5, 2, 1, 3, false"
    })
    void testEqualsCsvSource(Long id1, int minutesPlayed1, int pointsScored1, int threePointersMade1, 
                             int threePointersAttempted1, int freeThrowsMade1, int freeThrowsAttempted1, 
                             int reboundsOffensive1, int reboundsDefensive1, int assists1, 
                             int steals1, int blocks1, int personalFouls1, 
                             Long id2, int minutesPlayed2, int pointsScored2, int threePointersMade2, 
                             int threePointersAttempted2, int freeThrowsMade2, int freeThrowsAttempted2, 
                             int reboundsOffensive2, int reboundsDefensive2, int assists2, 
                             int steals2, int blocks2, int personalFouls2, boolean expected) {
        Player player1 = new Player();
        player1.setId(1L);
        
        Game game1 = new Game();
        game1.setId(1L);

        PlayerStatistic playerStatistic1 = new PlayerStatistic();
        playerStatistic1.setId(id1);
        playerStatistic1.setPlayer(player1);
        playerStatistic1.setGame(game1);
        playerStatistic1.setMinutesPlayed(minutesPlayed1);
        playerStatistic1.setPointsScored(pointsScored1);
        playerStatistic1.setThreePointersMade(threePointersMade1);
        playerStatistic1.setThreePointersAttempted(threePointersAttempted1);
        playerStatistic1.setFreeThrowsMade(freeThrowsMade1);
        playerStatistic1.setFreeThrowsAttempted(freeThrowsAttempted1);
        playerStatistic1.setReboundsOffensive(reboundsOffensive1);
        playerStatistic1.setReboundsDefensive(reboundsDefensive1);
        playerStatistic1.setAssists(assists1);
        playerStatistic1.setSteals(steals1);
        playerStatistic1.setBlocks(blocks1);
        playerStatistic1.setPersonalFouls(personalFouls1);

        PlayerStatistic playerStatistic2 = new PlayerStatistic();
        playerStatistic2.setId(id2);
        playerStatistic2.setPlayer(player1);
        playerStatistic2.setGame(game1);
        playerStatistic2.setMinutesPlayed(minutesPlayed2);
        playerStatistic2.setPointsScored(pointsScored2);
        playerStatistic2.setThreePointersMade(threePointersMade2);
        playerStatistic2.setThreePointersAttempted(threePointersAttempted2);
        playerStatistic2.setFreeThrowsMade(freeThrowsMade2);
        playerStatistic2.setFreeThrowsAttempted(freeThrowsAttempted2);
        playerStatistic2.setReboundsOffensive(reboundsOffensive2);
        playerStatistic2.setReboundsDefensive(reboundsDefensive2);
        playerStatistic2.setAssists(assists2);
        playerStatistic2.setSteals(steals2);
        playerStatistic2.setBlocks(blocks2);
        playerStatistic2.setPersonalFouls(personalFouls2);

        boolean result = playerStatistic1.equals(playerStatistic2);       

        assertEquals(expected, result);
    }
}
