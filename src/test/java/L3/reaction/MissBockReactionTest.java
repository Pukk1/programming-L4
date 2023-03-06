package L3.reaction;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissBockReactionTest {

    @ParameterizedTest
    @CsvSource({
            "BLUSH,GRUNT,0",
            "BLUSH,SILENCE,-1",
            "BLUSH,LAUGHTER,2",
            "BLUSH,GROAN,10",
            "CALMFACE,GRUNT,-1",
            "CALMFACE,GROAN,9",
            "CALMFACE,LAUGHTER,1",
            "CALMFACE,SILENCE,-2",
            "SMILE,GRUNT,2",
            "SMILE,GROAN,12",
            "SMILE,LAUGHTER,4",
            "SMILE,SILENCE,1",
    })
    void react(FaceReaction faceReaction, NoiseReaction noiseReaction, int expectedChangeLevelOfEmotionality) {
        MissBockReaction missBockReaction = new MissBockReaction(faceReaction, noiseReaction);
        int changeLevelOfEmotionality = missBockReaction.reactToRoomState();
        assertEquals(expectedChangeLevelOfEmotionality, changeLevelOfEmotionality);
    }
}