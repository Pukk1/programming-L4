package L3.action;

import L3.data.ReactionsData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissBockActionTest {


    @ParameterizedTest
    @CsvSource({
            "-100,CALMFACE,SILENCE",
            "-1,CALMFACE,SILENCE",
            "0,CALMFACE,SILENCE",
            "1,CALMFACE,SILENCE",
            "2,BLUSH,SILENCE",
            "3,BLUSH,GROAN",
            "10,BLUSH,GROAN",
            "100,BLUSH,GROAN"
    })
    void doAction(int levelOfEmotionality, FaceReaction expectedFaceReaction, NoiseReaction expectedNoiseReaction) {
        MissBockAction humanAction = new MissBockAction();
        ReactionsData reactionsData = humanAction.doAction(levelOfEmotionality);
        assertEquals(expectedFaceReaction, reactionsData.getFaceReaction());
        assertEquals(expectedNoiseReaction, reactionsData.getNoiseReaction());
    }
}