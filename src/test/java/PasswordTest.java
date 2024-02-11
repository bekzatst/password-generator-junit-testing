import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    public void testConstructor() {
        Password password = new Password("Qwerty123!");
        assertEquals("Qwerty123!", password.Value);
        assertEquals(10, password.Length);
    }

    @Test
    public void testPasswordStrength() {
        Password strongPassword = new Password("T3stP@ssw0rd");
        assertEquals(5, strongPassword.PasswordStrength());

    }

    @Test
    public void testCalculateScore() {
        Password goodPassword = new Password("Test123!");
        assertEquals("This is a good password :) but you can still do better", goodPassword.calculateScore());

    }

}