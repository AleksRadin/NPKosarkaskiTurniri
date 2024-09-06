package operation.listOfReferees;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import domain.Game;
import domain.League;
import domain.ListOfReferees;
import domain.Referee;
import controller.Controller;

public class AddListOfRefereesTest {

    @Test
    void testExecuteOperation() throws Exception {
        
        List<Referee> referees = Controller.getInstance().getAllReferees(new Referee());

        
        if (referees.size() < 3) {
            fail("Not enough referees in the database to form a valid list.");
        }

        Random random = new Random();
        Referee headReferee = referees.get(0); 
        Referee firstReferee = referees.get(1); 
        Referee secondReferee = referees.get(2); 
        Game game = new Game(1L, LocalDate.of(2024, 9, 5), LocalTime.of(20, 0), new League(1L, "Premier League", "2023-2024"));
        

        ListOfReferees listOfReferees = new ListOfReferees(1L, headReferee, firstReferee, secondReferee, game);

        boolean uniqueCombinationFound = false;


        while (!uniqueCombinationFound) {

            headReferee = referees.get(random.nextInt(referees.size()));
            firstReferee = referees.get(random.nextInt(referees.size()));
            secondReferee = referees.get(random.nextInt(referees.size()));


            while (firstReferee.equals(headReferee)) {
                firstReferee = referees.get(random.nextInt(referees.size()));
            }
            while (secondReferee.equals(headReferee) || secondReferee.equals(firstReferee)) {
                secondReferee = referees.get(random.nextInt(referees.size()));
            }

            listOfReferees = new ListOfReferees(1L, headReferee, firstReferee, secondReferee, game);

            List<ListOfReferees> allListsOfReferees = Controller.getInstance().getAllListOfReferees(new ListOfReferees());
            uniqueCombinationFound = true;
            for (ListOfReferees l : allListsOfReferees) {
                if (l.getHeadReferee().getId().equals(listOfReferees.getHeadReferee().getId()) &&
                    l.getFirstReferee().getId().equals(listOfReferees.getFirstReferee().getId()) &&
                    l.getSecondReferee().getId().equals(listOfReferees.getSecondReferee().getId()) &&
                    l.getGame().getId().equals(listOfReferees.getGame().getId())) {
                    uniqueCombinationFound = false;
                    break;
                }
            }
        }

        try {
            Controller.getInstance().addListOfReferees(listOfReferees);
        } catch (IllegalArgumentException e) {
            fail("Failed to add list of referees: " + e.getMessage());
        }

        List<ListOfReferees> currentListsOfReferees = Controller.getInstance().getAllListOfReferees(new ListOfReferees());
        boolean containsList = false;
        for (ListOfReferees l : currentListsOfReferees) {
            if (l.getHeadReferee().getId().equals(listOfReferees.getHeadReferee().getId()) &&
                l.getFirstReferee().getId().equals(listOfReferees.getFirstReferee().getId()) &&
                l.getSecondReferee().getId().equals(listOfReferees.getSecondReferee().getId()) &&
                l.getGame().getId().equals(listOfReferees.getGame().getId())) {
                containsList = true;
                break;
            }
        }

        assertTrue(containsList, "The added list of referees should be present in the list.");
    }
}
