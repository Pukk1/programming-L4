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

class MissBockTest {

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
            "10,10,SILENCE,SMILE,SILENCE,CALMFACE,MissBockName спокойна и пьёт кофе Наступает тишина,true",
            "0,10,SILENCE,SMILE,SILENCE,CALMFACE,MissBockName спокойна и пьёт кофе Наступает тишина,true",
            "0,10,LAUGHTER,CALMFACE,SILENCE,CALMFACE,MissBockName спокойна и пьёт кофе Наступает тишина,true",
            "0,10,GROAN,CALMFACE,GROAN,BLUSH,MissBockName краснеет MissBockName охает,true",
            "0,10,GRUNT,CALMFACE,SILENCE,CALMFACE,MissBockName спокойна и пьёт кофе Наступает тишина,true",
            "0,0,GRUNT,CALMFACE,SILENCE,CALMFACE,MissBockName спокойна и пьёт кофе Наступает тишина,true",
    })
    void testLooksListensReacts(int number_of_cakes, int start_number_of_cakes, Noise startNoise,
                                FaceReaction startFaceReaction, Noise expectedNoise, FaceReaction expectedFaceReaction,
                                String expectedSysOut, Boolean expectedIsMissBockTurn) {
        MissBock missBock = new MissBock();
        DataFromRoom dataFromRoom = new DataFromRoom(number_of_cakes, start_number_of_cakes, startNoise, startFaceReaction);
        ChangesMadeByPeople changes = missBock.looksListensReacts(dataFromRoom, "MissBockName");
        assertEquals(expectedNoise, changes.noise);
        assertEquals(expectedFaceReaction, changes.faceReaction);
        assertEquals(expectedSysOut, outputStreamCaptor.toString().replaceAll("\r\n", " ").trim());
        assertEquals(expectedIsMissBockTurn, missBock.isMissBockTurn());
    }
}