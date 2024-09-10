package operation.coach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Coach;
import domain.Team;
import controller.Controller;

public class EditCoachTest {

    @Test
    void testExecuteOperation() throws Exception {
        Team team = new Team(1L, "Real Madrid", "Madrid", "Spain", 1902);
        Coach coach = new Coach(1L, "Zinedine", "Zidane", 3, team);
        
        Controller.getInstance().addCoach(coach);
        
        List<Coach> allCoaches = Controller.getInstance().getAllCoaches(new Coach());
        assertTrue(allCoaches.contains(coach), "Coach should be present before editing.");
        
        
        coach.setNumbOfChampionships(4);
        
        Controller.getInstance().editCoach(coach);
        
        allCoaches = Controller.getInstance().getAllCoaches(new Coach());
        assertTrue(allCoaches.contains(coach), "The edited coach should be present in the list.");
        
    }
}
