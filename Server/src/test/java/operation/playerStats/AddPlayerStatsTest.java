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

    	Player player = new Player(1L, "LeBron", "James", LocalDate.of(1984, 12, 30), "CENTER", 206, 113, PlayerState.UNCHANGED);
        Game game = new Game(1L, LocalDate.of(2024, 9, 5), LocalTime.of(20, 0), new League(1L, "NBA", "2023-2024"));
        
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
        playerStatistic.setPersonalFouls(2);

        Controller.getInstance().addPlayerStats(playerStatistic);


        List<PlayerStatistic> allPlayerStats = Controller.getInstance().getAllPlayersStats(new PlayerStatistic());

        boolean containsPlayerStat = false;
        for (PlayerStatistic ps : allPlayerStats) {
            if (ps.getId().equals(playerStatistic.getId())) {
                containsPlayerStat = true;
                break;
            }
        }


        assertTrue(containsPlayerStat, "The added player statistic should be present in the list.");
    }
}
