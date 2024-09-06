package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TeamStatisticTest {

    private TeamStatistic teamStatistic;
    private League league;
    private Team team;

    @BeforeEach
    void setUp() throws Exception {
        league = new League();
        league.setId(1L);

        team = new Team();
        team.setId(1L);

        teamStatistic = new TeamStatistic();
    }

    @AfterEach
    void tearDown() throws Exception {
        teamStatistic = null;
        league = null;
        team = null;
    }

    @Test
    void testSetId() {
        teamStatistic.setId(5L);
        assertEquals(5L, teamStatistic.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> teamStatistic.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setId(0L));
    }

    @Test
    void testSetLeague() {
        teamStatistic.setLeague(league);
        assertEquals(league, teamStatistic.getLeague());
    }

    @Test
    void testSetLeagueNull() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setLeague(null));
    }

    @Test
    void testSetTeam() {
        teamStatistic.setTeam(team);
        assertEquals(team, teamStatistic.getTeam());
    }

    @Test
    void testSetTeamNull() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setTeam(null));
    }

    @Test
    void testSetPoints() {
        teamStatistic.setPoints(10);
        assertEquals(10, teamStatistic.getPoints());
    }

    @Test
    void testSetPointsNegative() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setPoints(-1));
    }

    @Test
    void testSetPlayedGames() {
        teamStatistic.setPlayedGames(5);
        assertEquals(5, teamStatistic.getPlayedGames());
    }

    @Test
    void testSetPlayedGamesNegative() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setPlayedGames(-1));
    }

    @Test
    void testSetWonGames() {
        teamStatistic.setWonGames(3);
        assertEquals(3, teamStatistic.getWonGames());
    }

    @Test
    void testSetWonGamesNegative() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setWonGames(-1));
    }

    @Test
    void testSetLostGames() {
        teamStatistic.setLostGames(2);
        assertEquals(2, teamStatistic.getLostGames());
    }

    @Test
    void testSetLostGamesNegative() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setLostGames(-1));
    }

    @Test
    void testSetDrawnGames() {
        teamStatistic.setDrawnGames(1);
        assertEquals(1, teamStatistic.getDrawnGames());
    }

    @Test
    void testSetDrawnGamesNegative() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setDrawnGames(-1));
    }

    @Test
    void testSetRank() {
        teamStatistic.setRank(2);
        assertEquals(2, teamStatistic.getRank());
    }

    @Test
    void testSetRankLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> teamStatistic.setRank(0));
    }

    @Test
    void testToString() {
        teamStatistic.setId(1L);
        teamStatistic.setLeague(league);
        teamStatistic.setTeam(team);
        teamStatistic.setPlayedGames(10);
        teamStatistic.setWonGames(5);
        teamStatistic.setLostGames(3);
        teamStatistic.setDrawnGames(2);
        teamStatistic.setPoints(17);
        teamStatistic.setRank(1);
        
        String result = teamStatistic.toString();
        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("league=" + league));
        assertTrue(result.contains("team=" + team));
        assertTrue(result.contains("playedGames=10"));
        assertTrue(result.contains("wonGames=5"));
        assertTrue(result.contains("lostGames=3"));
        assertTrue(result.contains("drawnGames=2"));
        assertTrue(result.contains("rank=1"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 1, 10, 5, 3, 2, 17, 1, 1, 1, 1, 10, 5, 3, 2, 17, 1, true",
        "1, 1, 1, 10, 5, 3, 2, 17, 1, 2, 1, 1, 10, 5, 3, 2, 18, 1, false",
        "1, 1, 1, 10, 5, 3, 2, 17, 1, 2, 1, 1, 10, 5, 3, 3, 17, 1, false",
        "1, 1, 1, 10, 5, 3, 2, 17, 1, 2, 2, 1, 10, 5, 3, 2, 17, 1, false",
        "1, 1, 1, 10, 5, 3, 2, 17, 1, 2, 1, 1, 10, 5, 3, 2, 17, 2, false"
    })
    void testEqualsCsvSource(Long id1, Long leagueId1, Long teamId1, int playedGames1, int wonGames1, int lostGames1, int drawnGames1, int points1, int rank1,
                             Long id2, Long leagueId2, Long teamId2, int playedGames2, int wonGames2, int lostGames2, int drawnGames2, int points2, int rank2, Boolean expected) {
        League league1 = new League();
        league1.setId(leagueId1);
        League league2 = new League();
        league2.setId(leagueId2);

        Team team1 = new Team();
        team1.setId(teamId1);
        Team team2 = new Team();
        team2.setId(teamId2);

        TeamStatistic ts1 = new TeamStatistic();
        ts1.setId(id1);
        ts1.setLeague(league1);
        ts1.setTeam(team1);
        ts1.setPlayedGames(playedGames1);
        ts1.setWonGames(wonGames1);
        ts1.setLostGames(lostGames1);
        ts1.setDrawnGames(drawnGames1);
        ts1.setPoints(points1);
        ts1.setRank(rank1);

        TeamStatistic ts2 = new TeamStatistic();
        ts2.setId(id2);
        ts2.setLeague(league2);
        ts2.setTeam(team2);
        ts2.setPlayedGames(playedGames2);
        ts2.setWonGames(wonGames2);
        ts2.setLostGames(lostGames2);
        ts2.setDrawnGames(drawnGames2);
        ts2.setPoints(points2);
        ts2.setRank(rank2);
        
        

        assertEquals(expected, ts1.equals(ts2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(teamStatistic.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(teamStatistic.equals(teamStatistic));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(teamStatistic.equals(new Exception()));
    }
}
