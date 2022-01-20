import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @DisplayName("Dividing on 3")
    void divide() {
        assertTrue(Utility.divisibleByThree("123"));
        assertTrue(Utility.divisibleByThree("8409"));
        assertTrue(Utility.divisibleByThree("33333333"));
        assertTrue(Utility.divisibleByThree("-123"));

        assertFalse(Utility.divisibleByThree(""));
        assertFalse(Utility.divisibleByThree("7"));
        assertFalse(Utility.divisibleByThree("100853"));

    }

    @Test
    @DisplayName("Crypto")
    void encrypto() {
        assertEquals("", Utility.encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", Utility.encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", Utility.encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", Utility.encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", Utility.encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", Utility.encryptThis("Thank you Piotr for all your help"));
        assertEquals("104olle 119drlo", Utility.encryptThis("hello world"));
    }
}