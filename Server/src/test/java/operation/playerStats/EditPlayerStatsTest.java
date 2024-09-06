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
    	Player player = new Player(1L, "LeBron", "James", LocalDate.of(1984, 12, 30), "CENTER", 206, 113, PlayerState.UNCHANGED);
        Game game = new Game(1L, LocalDate.of(2024, 9, 5), LocalTime.of(20, 0), new League(1L, "Premier League", "2023-2024"));



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


        List<PlayerStatistic> allPlayerStats = (List<PlayerStatistic>) Controller.getInstance().getAllPlayersStats(new PlayerStatistic());


        boolean containsEditedPlayerStat = false;
        for (PlayerStatistic ps : allPlayerStats) {
            if (ps.getId().equals(playerStatistic.getId()) &&
                ps.getPointsScored() == playerStatistic.getPointsScored() &&
                ps.getReboundsDefensive() == playerStatistic.getReboundsDefensive()) {
                containsEditedPlayerStat = true;
                break;
            }
        }

        assertTrue(containsEditedPlayerStat, "The edited player statistics should be present and updated in the list.");
    }
}
