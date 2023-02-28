package L3.Action;

import L3.ChangesMadeByPeople;
import L3.FaceReaction;
import L3.Noise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallBoyActionTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @CsvSource({
            "3,SmallBoy,LAUGHTER,SMILE,SmallBoy улыбается SmallBoy смеётся",
            "2,SmallBoy,SILENCE,SMILE,SmallBoy улыбается Наступает тишина",
            "1,SmallBoy,SILENCE,CALMFACE,SmallBoy спокоен Наступает тишина",
            "0,SmallBoy,SILENCE,CALMFACE,SmallBoy спокоен Наступает тишина",
            "-1,SmallBoy,SILENCE,CALMFACE,SmallBoy спокоен Наступает тишина",
    })
    public void testStart(int level_of_emotionality, String name, Noise noise, FaceReaction faceReaction, String output) {
        SmallBoyAction action = new SmallBoyAction();
        ChangesMadeByPeople changes = action.start(level_of_emotionality, name);
        assertEquals(changes.faceReaction, faceReaction);
        assertEquals(changes.noise, noise);
        assertEquals(output, outputStreamCaptor.toString().replaceAll("\r\n", " ").trim());
    }
}