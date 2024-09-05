package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @AfterEach
    void tearDown() {
        referee = null;
    }

    @Test
    void testSetId() {
        referee.setId(5L);
        assertEquals(5L, referee.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> referee.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> referee.setId(0L));
    }

    @Test
    void testSetFirstname() {
        referee.setFirstname("John");
        assertEquals("John", referee.getFirstname());
    }

    @Test
    void testSetFirstnameNull() {
        assertThrows(IllegalArgumentException.class, () -> referee.setFirstname(null));
    }

    @Test
    void testSetFirstnameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> referee.setFirstname(""));
    }

    @Test
    void testSetLastname() {
        referee.setLastname("Doe");
        assertEquals("Doe", referee.getLastname());
    }

    @Test
    void testSetLastnameNull() {
        assertThrows(IllegalArgumentException.class, () -> referee.setLastname(null));
    }

    @Test
    void testSetLastnameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> referee.setLastname(""));
    }

    @Test
    void testToString() {
        referee.setFirstname("John");
        referee.setLastname("Doe");
        String result = referee.toString();
        assertEquals("John Doe", result);
    }

    @ParameterizedTest
    @CsvSource({
        "1, John, Doe, 1, John, Doe, true",
        "1, John, Doe, 2, John, Doe, false",
        "1, John, Doe, 1, Jane, Doe, false",
        "1, John, Doe, 1, John, Smith, false"
    })
    void testEqualsCsvSource(Long id1, String firstname1, String lastname1, Long id2, String firstname2, String lastname2, boolean expected) {
        referee.setId(id1);
        referee.setFirstname(firstname1);
        referee.setLastname(lastname1);

        Referee otherReferee = new Referee();
        otherReferee.setId(id2);
        otherReferee.setFirstname(firstname2);
        otherReferee.setLastname(lastname2);

        assertEquals(expected, referee.equals(otherReferee));
    }

    @Test
    void testEqualsNull() {
        assertFalse(referee.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(referee.equals(referee));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(referee.equals(new Exception()));
    }
}
