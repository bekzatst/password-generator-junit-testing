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
        Password veryGoodPassword = new Password("Test123Very456Good!");
        assertEquals("This is a very good password :D check the Useful Information section to" +
                " make sure it satisfies the guidelines", veryGoodPassword.calculateScore());

        Password goodPassword = new Password("Test123!");
        assertEquals("This is a good password :) but you can still do better", goodPassword.calculateScore());

        Password mediumPassword = new Password("Test123");
        assertEquals("This is a medium password :/ try making it better", mediumPassword.calculateScore());

        Password weakPassword = new Password("pass12");
        assertEquals("This is a weak password :( definitely find a new one", weakPassword.calculateScore());

    }

}