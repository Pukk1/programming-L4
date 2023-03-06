package L3.humans;

import L3.data.ReactionsData;
import L3.data.RoomStateData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SmallBoyTest {

    @ParameterizedTest
    @CsvSource({
            "GRUNT,BLUSH,LAUGHTER,SMILE",
            "GROAN,BLUSH,LAUGHTER,SMILE",
            "LAUGHTER,BLUSH,SILENCE,CALMFACE",
            "SILENCE,BLUSH,SILENCE,CALMFACE",
            "GRUNT,CALMFACE,LAUGHTER,SMILE",
            "GROAN,CALMFACE,SILENCE,CALMFACE",
            "LAUGHTER,CALMFACE,SILENCE,CALMFACE",
            "SILENCE,CALMFACE,SILENCE,CALMFACE",
            "GRUNT,SMILE,LAUGHTER,SMILE",
            "GROAN,SMILE,SILENCE,CALMFACE",
            "LAUGHTER,SMILE,SILENCE,CALMFACE",
            "SILENCE,SMILE,SILENCE,CALMFACE",
    })
    void reactToRoomState(NoiseReaction noiseReaction, FaceReaction faceReaction,
                          NoiseReaction expectedNoiseReaction, FaceReaction expectedFaceReaction) {
        SmallBoy smallBoy = new SmallBoy("Small boy");
        RoomStateData roomStateData = new RoomStateData(0, 0, noiseReaction, faceReaction);
        ReactionsData resData = smallBoy.reactToRoomState(roomStateData);
        assertEquals(expectedFaceReaction, resData.getFaceReaction());
        assertEquals(expectedNoiseReaction, resData.getNoiseReaction());
    }
}