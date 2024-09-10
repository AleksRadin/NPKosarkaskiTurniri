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
    	List<League> allLeagues = (List<League>) Controller.getInstance().getAllLeagues(new League());
    	League league = allLeagues.get(0);
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
        allLeagues = (List<League>) Controller.getInstance().getAllLeagues(new League());
        for (TeamStatistic teamStat : allTeamStats) {
			for (League league2 : allLeagues) {
				if(teamStat.getLeague().getId().equals(league2.getId())) {
					teamStat.setLeague(league2);
				}
			}
		}
        
        
        assertTrue(allTeamStats.contains(teamStatistic), "The edited team statistic should be present and updated in the list.");
    }
}
