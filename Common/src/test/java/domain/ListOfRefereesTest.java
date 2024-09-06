package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListOfRefereesTest {

    private Referee headReferee1;
    private Referee firstReferee1;
    private Referee secondReferee1;
    private Game game1;

    private Referee headReferee2;
    private Referee firstReferee2;
    private Referee secondReferee2;
    private Game game2;

    private ListOfReferees listOfReferees1;
    private ListOfReferees listOfReferees2;

    @BeforeEach
    void setUp() {
        headReferee1 = new Referee();
        firstReferee1 = new Referee();
        secondReferee1 = new Referee();
        game1 = new Game();

        headReferee2 = new Referee();
        firstReferee2 = new Referee();
        secondReferee2 = new Referee();
        game2 = new Game();

        listOfReferees1 = new ListOfReferees(1L, headReferee1, firstReferee1, secondReferee1, game1);
        listOfReferees2 = new ListOfReferees(1L, headReferee2, firstReferee2, secondReferee2, game2);
    }

    @Test
    void testSetId() {
        listOfReferees1.setId(2L);
        assertEquals(2L, listOfReferees1.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> listOfReferees1.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> listOfReferees1.setId(0L));
    }

    @Test
    void testSetHeadReferee() {
        listOfReferees1.setHeadReferee(headReferee2);
        assertEquals(headReferee2, listOfReferees1.getHeadReferee());
    }

    @Test
    void testSetHeadRefereeNull() {
        assertThrows(NullPointerException.class, () -> listOfReferees1.setHeadReferee(null));
    }

    @Test
    void testSetFirstReferee() {
        listOfReferees1.setFirstReferee(firstReferee2);
        assertEquals(firstReferee2, listOfReferees1.getFirstReferee());
    }

    @Test
    void testSetFirstRefereeNull() {
        assertThrows(NullPointerException.class, () -> listOfReferees1.setFirstReferee(null));
    }

    @Test
    void testSetSecondReferee() {
        listOfReferees1.setSecondReferee(secondReferee2);
        assertEquals(secondReferee2, listOfReferees1.getSecondReferee());
    }

    @Test
    void testSetSecondRefereeNull() {
        assertThrows(NullPointerException.class, () -> listOfReferees1.setSecondReferee(null));
    }

    @Test
    void testSetGame() {
        listOfReferees1.setGame(game2);
        assertEquals(game2, listOfReferees1.getGame());
    }

    @Test
    void testSetGameNull() {
        assertThrows(NullPointerException.class, () -> listOfReferees1.setGame(null));
    }

    @Test
    void testToString() {
        String result = listOfReferees1.toString();
        assertTrue(result.contains("headReferee=" + headReferee1));
        assertTrue(result.contains("firstReferee=" + firstReferee1));
        assertTrue(result.contains("secondReferee=" + secondReferee1));
        assertTrue(result.contains("game=" + game1));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(listOfReferees1.equals(listOfReferees1));
    }

    @Test
    void testEqualsDifferentObjectsSameValues() {
        listOfReferees2 = new ListOfReferees(1L, headReferee1, firstReferee1, secondReferee1, game1);
        assertTrue(listOfReferees1.equals(listOfReferees2));
    }

    @Test
    void testEqualsDifferentObjectsDifferentValues() {
        listOfReferees2 = new ListOfReferees(2L, headReferee2, firstReferee2, secondReferee2, game2);
        assertFalse(listOfReferees1.equals(listOfReferees2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(listOfReferees1.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(listOfReferees1.equals(new Object()));
    }
}
