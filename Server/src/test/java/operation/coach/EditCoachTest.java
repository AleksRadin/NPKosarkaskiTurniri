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
        Coach coachToEdit = null;
        for (Coach c : allCoaches) {
            if (c.getId().equals(coach.getId())) {
                coachToEdit = c;
                break;
            }
        }
        
        if (coachToEdit != null) {
            coachToEdit.setNumbOfChampionships(4); 
            Controller.getInstance().editCoach(coachToEdit);
            
            allCoaches = Controller.getInstance().getAllCoaches(new Coach());
            
            boolean containsEditedCoach = false;
            for (Coach c : allCoaches) {
                if (c.equals(coachToEdit)) {
                    containsEditedCoach = true;
                    break;
                }
            }

            assertTrue(containsEditedCoach, "The edited coach should be present in the list.");
        }
    }
}
