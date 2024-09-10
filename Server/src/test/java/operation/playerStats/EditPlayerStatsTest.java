package operation.playerStats;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Game;
import domain.League;
import domain.Player;
import domain.PlayerStatistic;
import player.state.PlayerState;
import controller.Controller;

public class EditPlayerStatsTest {

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
        playerStatistic.setMinutesPlayed(30);
        playerStatistic.setPointsScored(25);
        playerStatistic.setThreePointersMade(3);
        playerStatistic.setThreePointersAttempted(6);
        playerStatistic.setFreeThrowsMade(5);
        playerStatistic.setFreeThrowsAttempted(8);
        playerStatistic.setReboundsOffensive(3);
        playerStatistic.setReboundsDefensive(7);
        playerStatistic.setAssists(4);
        playerStatistic.setSteals(2);
        playerStatistic.setBlocks(1);
        playerStatistic.setPersonalFouls(1);

        Controller.getInstance().addPlayerStats(playerStatistic);

        playerStatistic.setPointsScored(30); 
        playerStatistic.setReboundsDefensive(8); 

        Controller.getInstance().editPlayerStats(playerStatistic);


        List<PlayerStatistic> allPlayerStats = Controller.getInstance().getAllPlayersStats(new PlayerStatistic());
        
        for (PlayerStatistic playerStatistic2 : allPlayerStats) {
			if(playerStatistic2.getPlayer().getId() == 1) {
				playerStatistic2.setPlayer(player);
			}
		}   
        
        assertTrue(allPlayerStats.contains(playerStatistic), "The edited player statistics should be present and updated in the list.");
    }
}
