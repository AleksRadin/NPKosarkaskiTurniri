package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() throws Exception {
        user = new User();
    }

    @AfterEach
    void tearDown() throws Exception {
        user = null;
    }

    @Test
    void testSetId() {
        user.setId(5L);
        assertEquals(5L, user.getId());
    }

    @Test
    void testSetIdNull() {
        assertThrows(NullPointerException.class, () -> user.setId(null));
    }

    @Test
    void testSetIdLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> user.setId(0L));
    }

    @Test
    void testSetFirstname() {
        user.setFirstname("John");
        assertEquals("John", user.getFirstname());
    }

    @Test
    void testSetFirstnameNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setFirstname(null));
    }

    @Test
    void testSetFirstnameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> user.setFirstname(""));
    }

    @Test
    void testSetLastname() {
        user.setLastname("Doe");
        assertEquals("Doe", user.getLastname());
    }

    @Test
    void testSetLastnameNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setLastname(null));
    }

    @Test
    void testSetLastnameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> user.setLastname(""));
    }

    @Test
    void testSetUsername() {
        user.setUsername("johndoe");
        assertEquals("johndoe", user.getUsername());
    }

    @Test
    void testSetUsernameNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null));
    }

    @Test
    void testSetUsernameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
    }

    @Test
    void testSetPassword() {
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    void testSetPasswordNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
    }

    @Test
    void testSetPasswordEmpty() {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
    }

    @Test
    void testSetRole() {
        user.setRole("admin");
        assertEquals("admin", user.getRole());
    }

    @Test
    void testSetRoleNull() {
        assertThrows(IllegalArgumentException.class, () -> user.setRole(null));
    }

    @Test
    void testSetRoleEmpty() {
        assertThrows(IllegalArgumentException.class, () -> user.setRole(""));
    }

    @Test
    void testToString() {
        user.setId(1L);
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setUsername("johndoe");
        user.setPassword("password123");
        user.setRole("admin");

        String result = user.toString();
        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("firstname=John"));
        assertTrue(result.contains("lastname=Doe"));
        assertTrue(result.contains("username=johndoe"));
        assertTrue(result.contains("password=password123"));
        assertTrue(result.contains("role=admin"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, John, Doe, johndoe, password123, admin, 1, John, Doe, johndoe, password123, admin, true",
        "1, John, Doe, johndoe, password123, admin, 2, John, Doe, johndoe, password123, admin, false",
        "1, John, Doe, johndoe, password123, admin, 1, Jane, Doe, johndoe, password123, admin, false",
        "1, John, Doe, johndoe, password123, admin, 1, John, Doe, janedoe, password123, admin, false",
        "1, John, Doe, johndoe, password123, admin, 1, John, Doe, johndoe, differentpassword, admin, false",
        "1, John, Doe, johndoe, password123, admin, 1, John, Doe, johndoe, password123, user, false"
    })
    void testEqualsCsvSource(Long id1, String firstname1, String lastname1, String username1, String password1, String role1,
                             Long id2, String firstname2, String lastname2, String username2, String password2, String role2, boolean expected) {
        User user1 = new User();
        user1.setId(id1);
        user1.setFirstname(firstname1);
        user1.setLastname(lastname1);
        user1.setUsername(username1);
        user1.setPassword(password1);
        user1.setRole(role1);

        User user2 = new User();
        user2.setId(id2);
        user2.setFirstname(firstname2);
        user2.setLastname(lastname2);
        user2.setUsername(username2);
        user2.setPassword(password2);
        user2.setRole(role2);

        assertEquals(expected, user1.equals(user2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(user.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(user.equals(user));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(user.equals(new Object()));
    }
}
