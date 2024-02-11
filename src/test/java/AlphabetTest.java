import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetTest {
    @ParameterizedTest
    @ValueSource(booleans = {true, true})
    public void testGetAlphabet(Boolean bool){
        Alphabet alphabet1 = new Alphabet(bool, false, false, false);
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", alphabet1.getAlphabet());

        Alphabet alphabet2 = new Alphabet(false, bool, false, false);
        assertEquals("abcdefghijklmnopqrstuvwxyz", alphabet2.getAlphabet());
    }
}