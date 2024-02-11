import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {
    private Generator generator;

    @BeforeEach
    public void setUp() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        Scanner scanner = new Scanner(inputStream);
        generator = new Generator(true, true, true, true);
    }

    @Test
    public void testGeneratePassword() {
        Password password = generator.GeneratePassword(8);
        assertNotNull(password);
        assertEquals(8, password.Length);

        password = generator.GeneratePassword(16);
        assertNotNull(password);
        assertEquals(16, password.Length);
    }

    @Test
    public void testCheckPassword() {
        InputStream inputStream = new ByteArrayInputStream("Password123".getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        generator = new Generator(scanner);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        generator.checkPassword();
        assertNotNull(outputStream.toString());
        assertTrue(outputStream.toString().contains("good") || outputStream.toString().contains("medium") || outputStream.toString().contains("weak"));
    }

    @Test
    public void testIsInclude() {
        assertTrue(generator.isInclude("yes"));
        assertFalse(generator.isInclude("no"));
    }

    @Test
    public void testPasswordRequestError() {
        InputStream inputStream = new ByteArrayInputStream("invalid".getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        generator = new Generator(scanner);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        generator.PasswordRequestError("invalid");
        assertNotNull(outputStream.toString());
        assertTrue(outputStream.toString().contains("You have entered something incorrect let's go over it again"));
    }


    @Test
    public void testPrintUsefulInfo() {
        Scanner scanner = new Scanner(System.in);
        generator = new Generator(scanner);
        generator.printUsefulInfo();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertNotNull(outputStream.toString());
        assertDoesNotThrow(() -> generator.printUsefulInfo());
    }


    @Test
    public void testGeneratePasswordWithInvalidLength() {
        Password password = generator.GeneratePassword(-8);
        assertEquals("", password.toString());
    }


    @Test
    public void testPrintMenu() {
        assertDoesNotThrow(() -> generator.printMenu());
    }

    @Test
    public void testPrintQuitMessage() {
        generator.printMenu();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertNotNull(outputStream.toString());
        assertDoesNotThrow(() -> generator.printQuitMessage());
    }

    @Test
    public void testMainLoopQuit() {
        InputStream inputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        generator = new Generator(scanner);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        assertNotNull(outputStream.toString());
        assertDoesNotThrow(() -> generator.mainLoop());
    }


}
