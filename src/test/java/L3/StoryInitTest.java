package L3;

import L3.exceptions.NameInSmallLettersException;
import L3.exceptions.NegativeValueOfCakesException;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class StoryInitTest {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    private void setInput(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }

    @ParameterizedTest
    @CsvSource({
            "miss Bock,small Boy",
            "miss Bock,Small Boy",
            "Miss Bock,small Boy",
    })
    void testNameInSmallLettersException(String missBockName, String smallBoyName) {
        setInput(missBockName + "\n" + smallBoyName);
        assertThrows(
                NameInSmallLettersException.class,
                Main.StoryInit::initRoom
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Miss Bock,Small Boy,-100",
            "Miss Bock,Small Boy,-10",
            "Miss Bock,Small Boy,-1",
    })
    void testNegativeValueOfCakesException(String missBockName, String smallBoyName, int startNumberOfCakesInRoom) {
        setInput(missBockName + "\n" + smallBoyName + "\n" + startNumberOfCakesInRoom);
        assertThrows(
                NegativeValueOfCakesException.class,
                Main.StoryInit::initRoom
        );
    }

    @ParameterizedTest
    @CsvSource({
            "Miss Bock,Small Boy,0",
            "MB,SB,10",
            "MMM,SBB Boy,100",
    })
    void testInitRoom(String missBockName, String smallBoyName, int startNumberOfCakesInRoom) throws NameInSmallLettersException {
        setInput(missBockName + "\n" + smallBoyName + "\n" + startNumberOfCakesInRoom);
        Room room = Main.StoryInit.initRoom();
        Room.ConditionInRoom condition = room.getCondition();
        assertEquals(smallBoyName, condition.getSmallBoy().getName());
        assertEquals(missBockName, condition.getMissBock().getName());
        assertEquals(startNumberOfCakesInRoom, condition.getStartNumberOfCakes());
        assertEquals(NoiseReaction.SILENCE, condition.getNoiseReactionInRoom());
        assertEquals(FaceReaction.CALMFACE, condition.getFaceReactionInRoom());
        assertEquals(startNumberOfCakesInRoom, condition.getNumberOfCakes());
        assertFalse(condition.isCarlsonSpalen());
    }
}
