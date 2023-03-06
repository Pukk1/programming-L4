package L3.action;

import L3.data.ReactionsData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SmallBoyActionTest {

    @ParameterizedTest
    @CsvSource({
            "-100,CALMFACE,SILENCE",
            "-1,CALMFACE,SILENCE",
            "0,CALMFACE,SILENCE",
            "1,CALMFACE,SILENCE",
            "2,SMILE,SILENCE",
            "3,SMILE,LAUGHTER",
            "10,SMILE,LAUGHTER",
            "100,SMILE,LAUGHTER"
    })
    void doAction(int levelOfEmotionality, FaceReaction expectedFaceReaction, NoiseReaction expectedNoiseReaction) {
        SmallBoyAction humanAction = new SmallBoyAction();
        ReactionsData reactionsData = humanAction.doAction(levelOfEmotionality);
        assertEquals(expectedFaceReaction, reactionsData.getFaceReaction());
        assertEquals(expectedNoiseReaction, reactionsData.getNoiseReaction());
    }
}