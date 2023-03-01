package L3.Humans;

import L3.ChangesMadeByPeople;
import L3.DataFromRoom;
import L3.FaceReaction;
import L3.Noise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallBoyTest {

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
            "10,10,SILENCE,SMILE,SILENCE,CALMFACE,SmallBoyName спокоен Наступает тишина",
            "0,10,SILENCE,SMILE,LAUGHTER,SMILE,SmallBoyName улыбается SmallBoyName смеётся",
            "0,100,SILENCE,SMILE,LAUGHTER,SMILE,SmallBoyName улыбается SmallBoyName смеётся",
            "0,0,LAUGHTER,SMILE,SILENCE,CALMFACE,SmallBoyName спокоен Наступает тишина",
            "0,0,GROAN,BLUSH,LAUGHTER,SMILE,SmallBoyName улыбается SmallBoyName смеётся",
            "0,0,GRUNT,CALMFACE,LAUGHTER,SMILE,SmallBoyName улыбается SmallBoyName смеётся",
    })
    void looksListensReacts(int number_of_cakes, int start_number_of_cakes, Noise startNoise,
                            FaceReaction startFaceReaction, Noise expectedNoise, FaceReaction expectedFaceReaction,
                            String expectedOutput) {
        SmallBoy smallBoy = new SmallBoy();
        DataFromRoom dataFromRoom = new DataFromRoom(number_of_cakes, start_number_of_cakes, startNoise, startFaceReaction);
        ChangesMadeByPeople changes = smallBoy.looksListensReacts(dataFromRoom, "SmallBoyName");
        assertEquals(expectedNoise, changes.noise);
        assertEquals(expectedFaceReaction, changes.faceReaction);
        assertEquals(expectedOutput, outputStreamCaptor.toString().replaceAll("\r\n", " ").trim());
    }
}