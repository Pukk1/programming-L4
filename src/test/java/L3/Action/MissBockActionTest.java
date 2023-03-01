package L3.Action;

import L3.ChangesMadeByPeople;
import L3.FaceReaction;
import L3.Noise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissBockActionTest {

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
            "3,BLUSH,GROAN,MissBock краснеет MissBock охает",
            "2,BLUSH,SILENCE,MissBock краснеет Наступает тишина",
            "1,CALMFACE,SILENCE,MissBock спокойна и пьёт кофе Наступает тишина",
            "0,CALMFACE,SILENCE,MissBock спокойна и пьёт кофе Наступает тишина",
            "-1,CALMFACE,SILENCE,MissBock спокойна и пьёт кофе Наступает тишина",
    })
    public void testStart(int level_of_emotionality, FaceReaction faceReaction, Noise noise, String output) {
        MissBockAction action = new MissBockAction();
        ChangesMadeByPeople changes = action.start(level_of_emotionality, "MissBock");
        assertEquals(changes.faceReaction, faceReaction);
        assertEquals(changes.noise, noise);
        assertEquals(output, outputStreamCaptor.toString().replaceAll("\r\n", " ").trim());
    }

    @Test
    public void testNaming() {
        MissBockAction missBockAction = new MissBockAction();
        MissBockAction action = new MissBockAction();
        String testName = "MissBockName";
        action.start(0, testName);
        assertEquals(testName, action.getName());
    }
}