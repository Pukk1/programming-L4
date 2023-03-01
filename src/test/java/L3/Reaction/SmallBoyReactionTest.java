package L3.Reaction;

import L3.DataFromRoom;
import L3.FaceReaction;
import L3.Noise;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallBoyReactionTest {

    @ParameterizedTest
    @CsvSource({
            "0,10,GROAN,BLUSH,14",
            "0,0,GROAN,BLUSH,3",
            "0,0,GRUNT,CALMFACE,8",
            "0,0,SILENCE,CALMFACE,-3",
            "0,1,SILENCE,CALMFACE,-1",
    })
    void testStart(int number_of_cakes, int start_number_of_cakes, Noise noise, FaceReaction faceReaction, int expectedEmotionalLevelChanging) {
        SmallBoyReaction smallBoyReaction = new SmallBoyReaction();
        DataFromRoom dataFromRoom = new DataFromRoom(number_of_cakes, start_number_of_cakes, noise, faceReaction);
        assertEquals(expectedEmotionalLevelChanging, smallBoyReaction.start(dataFromRoom));
    }
}