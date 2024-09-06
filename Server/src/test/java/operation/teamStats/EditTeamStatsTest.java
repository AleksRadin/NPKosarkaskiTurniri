package operation.teamStats;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.Controller;
import domain.League;
import domain.Team;
import domain.TeamStatistic;

public class EditTeamStatsTest {

    @Test
    void testExecuteOperation() throws Exception {
        League league = new League(1L, "NBA", "2023-2024");

        Team team = new Team();
        team.setId(1L);
        team.setName("Lakers");
        team.setCity("Los Angeles");
        team.setCountry("USA");
        team.setFoundedIn(1947);

        TeamStatistic teamStatistic = new TeamStatistic();
        teamStatistic.setId(1L);
        teamStatistic.setLeague(league);
        teamStatistic.setTeam(team);
        teamStatistic.setPlayedGames(82);
        teamStatistic.setWonGames(50);
        teamStatistic.setLostGames(32);
        teamStatistic.setDrawnGames(0);
        teamStatistic.setPoints(100);
        teamStatistic.setRank(1);

        Controller.getInstance().addTeamStat(teamStatistic);

        teamStatistic.setWonGames(55);
        teamStatistic.setPoints(110);

        Controller.getInstance().editTeamStat(teamStatistic);

        List<TeamStatistic> allTeamStats = (List<TeamStatistic>) Controller.getInstance().getAllTeamStats(new TeamStatistic());

        boolean containsEditedTeamStat = false;
        for (TeamStatistic ts : allTeamStats) {
            if (ts.getId().equals(teamStatistic.getId()) &&
                ts.getWonGames() == teamStatistic.getWonGames() &&
                ts.getPoints() == teamStatistic.getPoints()) {
                containsEditedTeamStat = true;
                break;
            }
        }

        assertTrue(containsEditedTeamStat, "The edited team statistics should be present and updated in the list.");
    }
}
