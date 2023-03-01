package L3.Reaction;

import L3.DataFromRoom;
import L3.FaceReaction;
import L3.Noise;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissBockReactionTest {

    @ParameterizedTest
    @CsvSource({
            "LAUGHTER,SMILE,4",
            "GROAN,SMILE,12",
            "GROAN,CALMFACE,9",
            "SILENCE,CALMFACE,-2",
    })
    void testStart(Noise noise, FaceReaction faceReaction, int expectedEmotionalLevelChanging) {
        MissBockReaction reaction = new MissBockReaction();
        DataFromRoom dataFromRoom = new DataFromRoom(0, 0, noise, faceReaction);
        assertEquals(expectedEmotionalLevelChanging, reaction.start(dataFromRoom));
    }
}