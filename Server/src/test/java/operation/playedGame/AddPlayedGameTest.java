package operation.playedGame;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import domain.Game;
import domain.League;
import domain.PlayedGame;
import domain.Team;
import controller.Controller;

public class AddPlayedGameTest {

    @Test
    void testExecuteOperation() throws Exception {
      
        List<Team> allTeams = Controller.getInstance().getAllTeams(new Team());
        if (allTeams.size() < 2) {
            fail("Not enough teams in the database to perform the test.");
        }

        List<Game> allGames = Controller.getInstance().getAllGames(new Game());
        if (allGames.isEmpty()) {
            fail("No games found in the database. Please add a game first.");
        }

        Random random = new Random();
        boolean unique = false;
        PlayedGame playedGame = null;


        while (!unique) {

            Team homeTeam = allTeams.get(random.nextInt(allTeams.size()));
            Team awayTeam;
            do {
                awayTeam = allTeams.get(random.nextInt(allTeams.size()));
            } while (awayTeam.equals(homeTeam)); // Ensure away team is not the same as home team


            Game game = allGames.get(random.nextInt(allGames.size()));

            playedGame = new PlayedGame(homeTeam, awayTeam, game, 3, 2);


            List<PlayedGame> allPlayedGames = (List<PlayedGame>) Controller.getInstance().getAllPlayedGames(new PlayedGame());
            unique = true;
            for (PlayedGame pg : allPlayedGames) {
                if (pg.getHomeTeam().getId().equals(playedGame.getHomeTeam().getId()) &&
                    pg.getAwayTeam().getId().equals(playedGame.getAwayTeam().getId()) &&
                    pg.getGame().getId().equals(playedGame.getGame().getId())) {
                    unique = false;
                    break;
                }
            }
        }


        try {
            Controller.getInstance().addPlayedGame(playedGame);
        } catch (IllegalArgumentException e) {
            fail("Failed to add played game: " + e.getMessage());
        }


        List<PlayedGame> currentPlayedGames = (List<PlayedGame>) Controller.getInstance().getAllPlayedGames(new PlayedGame());
        boolean containsPlayedGame1 = false;
        for (PlayedGame pg : currentPlayedGames) {
            if (pg.getHomeTeam().getId().equals(playedGame.getHomeTeam().getId()) &&
                pg.getAwayTeam().getId().equals(playedGame.getAwayTeam().getId()) &&
                pg.getGame().getId().equals(playedGame.getGame().getId())) {
                containsPlayedGame1 = true;
                break;
            }
        }

        assertTrue(containsPlayedGame1, "The added played game should be present in the list.");
    }
}
