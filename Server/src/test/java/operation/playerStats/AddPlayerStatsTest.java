package operation.playerStats;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Game;
import domain.League;
import domain.Player;
import domain.PlayerStatistic;
import player.state.PlayerPosition;
import player.state.PlayerState;
import controller.Controller;

public class AddPlayerStatsTest {

    @Test
    void testExecuteOperation() throws Exception {

    	List<Player> allPlayers = Controller.getInstance().getAllPlayers(new Player());
    	List<Game> allGames = Controller.getInstance().getAllGames(new Game());
        
    	Player player = allPlayers.get(0); 
        Game game = allGames.get(0);
    	
        PlayerStatistic playerStatistic = new PlayerStatistic();
        playerStatistic.setId(1L); 
        playerStatistic.setPlayer(player);
        playerStatistic.setGame(game);
        playerStatistic.setMinutesPlayed(36);
        playerStatistic.setPointsScored(29);
        playerStatistic.setThreePointersMade(4);
        playerStatistic.setThreePointersAttempted(7);
        playerStatistic.setFreeThrowsMade(7);
        playerStatistic.setFreeThrowsAttempted(10);
        playerStatistic.setReboundsOffensive(2);
        playerStatistic.setReboundsDefensive(6);
        playerStatistic.setAssists(5);
        playerStatistic.setSteals(1);
        playerStatistic.setBlocks(1);
        playerStatistic.setPersonalFouls(66);

        Controller.getInstance().addPlayerStats(playerStatistic);

        

        List<PlayerStatistic> allPlayerStats = Controller.getInstance().getAllPlayersStats(new PlayerStatistic());
        
        for (PlayerStatistic playerStatistic2 : allPlayerStats) {
			if(playerStatistic2.getPlayer().getId() == 1) {
				playerStatistic2.setPlayer(player);
			}
		}   
        assertTrue(allPlayerStats.contains(playerStatistic), "The added player statistic should be present in the list.");
    }
}
