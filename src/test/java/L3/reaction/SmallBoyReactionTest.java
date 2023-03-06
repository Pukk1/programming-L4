package L3.reaction;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmallBoyReactionTest {

    @ParameterizedTest
    @CsvSource({
            "-1,0,numberOfCakes should be bigger than 0",
            "-1,10,numberOfCakes should be bigger than 0",
            "-1,-10,numberOfCakes should be bigger than 0",
            "-10,0,numberOfCakes should be bigger than 0",
            "-10,10,numberOfCakes should be bigger than 0",
            "-10,-10,numberOfCakes should be bigger than 0",
            "0,-1,numberOfCakes can't be bigger then startNumberOfCakes",
            "0,-10,numberOfCakes can't be bigger then startNumberOfCakes",
            "11,0,numberOfCakes can't be bigger then startNumberOfCakes",
            "11,-10,numberOfCakes can't be bigger then startNumberOfCakes",
            "11,10,numberOfCakes can't be bigger then startNumberOfCakes",
    })
    void testSmallBoyReactionIllegalInit(int numberOfCakes, int startNumberOfCakes, String mes) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SmallBoyReaction(
                        numberOfCakes,
                        startNumberOfCakes,
                        FaceReaction.CALMFACE,
                        NoiseReaction.SILENCE),
                mes

        );
    }


    @ParameterizedTest
    @CsvSource({
            "BLUSH,GRUNT,10,10,11",
            "BLUSH,GRUNT,100,100,11",
            "BLUSH,GRUNT,10,15,17",
            "BLUSH,GRUNT,100,150,62",
            "BLUSH,SILENCE,10,10,0",
            "BLUSH,SILENCE,100,100,0",
            "BLUSH,SILENCE,10,15,6",
            "BLUSH,SILENCE,100,150,51",
            "BLUSH,LAUGHTER,10,10,1",
            "BLUSH,LAUGHTER,100,100,1",
            "BLUSH,LAUGHTER,10,15,7",
            "BLUSH,LAUGHTER,100,150,52",
            "BLUSH,GROAN,10,10,3",
            "BLUSH,GROAN,100,100,3",
            "BLUSH,GROAN,10,15,9",
            "BLUSH,GROAN,100,150,54",
            "CALMFACE,GRUNT,10,10,8",
            "CALMFACE,GRUNT,100,100,8",
            "CALMFACE,GRUNT,10,15,14",
            "CALMFACE,GRUNT,100,150,59",
            "CALMFACE,GROAN,10,10,0",
            "CALMFACE,GROAN,100,100,0",
            "CALMFACE,GROAN,10,15,6",
            "CALMFACE,GROAN,100,150,51",
            "CALMFACE,LAUGHTER,10,10,-2",
            "CALMFACE,LAUGHTER,100,100,-2",
            "CALMFACE,LAUGHTER,10,15,4",
            "CALMFACE,LAUGHTER,100,150,49",
            "CALMFACE,SILENCE,10,10,-3",
            "CALMFACE,SILENCE,100,100,-3",
            "CALMFACE,SILENCE,10,15,3",
            "CALMFACE,SILENCE,100,150,48",
            "SMILE,GRUNT,10,10,9",
            "SMILE,GRUNT,100,100,9",
            "SMILE,GRUNT,10,15,15",
            "SMILE,GRUNT,100,150,60",
            "SMILE,GROAN,10,10,1",
            "SMILE,GROAN,100,100,1",
            "SMILE,GROAN,10,15,7",
            "SMILE,GROAN,100,150,52",
            "SMILE,LAUGHTER,10,10,-1",
            "SMILE,LAUGHTER,100,100,-1",
            "SMILE,LAUGHTER,10,15,5",
            "SMILE,LAUGHTER,100,150,50",
            "SMILE,SILENCE,10,10,-2",
            "SMILE,SILENCE,100,100,-2",
            "SMILE,SILENCE,10,15,4",
            "SMILE,SILENCE,100,150,49",
    })
    void react(FaceReaction faceReaction, NoiseReaction noiseReaction, int numberOfCakes, int startNumberOfCakes, int expectedChangeLevelOfEmotionality) {
        SmallBoyReaction smallBoyReaction = new SmallBoyReaction(numberOfCakes, startNumberOfCakes, faceReaction, noiseReaction);
        int changeLevelOfEmotionality = smallBoyReaction.reactToRoomState();
        assertEquals(expectedChangeLevelOfEmotionality, changeLevelOfEmotionality);
    }
}