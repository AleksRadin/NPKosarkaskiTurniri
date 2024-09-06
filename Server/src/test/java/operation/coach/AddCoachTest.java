package operation.coach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Coach;
import domain.Team;
import controller.Controller;

public class AddCoachTest {

    @Test
    void testExecuteOperation() throws Exception {
    	Team team = new Team(1L, "Real Madrid", "Madrid", "Spain", 1902);
        Coach coach = new Coach(1L, "Zinedine", "Zidane", 3, team);

        Controller.getInstance().addCoach(coach);

        List<Coach> allCoaches = Controller.getInstance().getAllCoaches(new Coach());

        boolean containsCoach = false;
        for (Coach c : allCoaches) {
            if (c.getId().equals(coach.getId())) {
                containsCoach = true;
                break;
            }
        }

        assertTrue(containsCoach);
    }
}
