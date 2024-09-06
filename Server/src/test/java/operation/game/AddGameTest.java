package operation.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Game;
import domain.League;
import controller.Controller;

public class AddGameTest {

    @Test
    void testExecuteOperation() throws Exception {
    	
        League league = new League(1L, "Premier League", "2023-2024");
        LocalDate gameDate = LocalDate.of(2024, 9, 5);
        LocalTime gameTime = LocalTime.of(20, 0);
        Game game = new Game(1L, gameDate, gameTime, league);
        
        Controller.getInstance().addGame(game);
        
        List<Game> allGames = Controller.getInstance().getAllGames(new Game());
        Game gameToVerify = null;
        for (Game g : allGames) {
            if (g.getId().equals(game.getId())) {
                gameToVerify = g;
                break;
            }
        }
        
        if (gameToVerify != null) {
            boolean containsGame = false;
            for (Game g : allGames) {
                if (g.equals(gameToVerify)) {
                    containsGame = true;
                    break;
                }
            }
            
            assertTrue(containsGame, "The added game should be present in the list.");
        }
    }
}
