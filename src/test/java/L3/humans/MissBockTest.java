package L3.humans;

import L3.data.ReactionsData;
import L3.data.RoomStateData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissBockTest {


    private MissBock missBock;
    @BeforeEach
    void initMissBock() {
        this.missBock = new MissBock("Miss Bock");
    }

    @ParameterizedTest
    @CsvSource({
            "GRUNT,BLUSH,SILENCE,CALMFACE",
            "GROAN,BLUSH,GROAN,BLUSH",
            "LAUGHTER,BLUSH,SILENCE,BLUSH",
            "SILENCE,BLUSH,SILENCE,CALMFACE",
            "GRUNT,CALMFACE,SILENCE,CALMFACE",
            "GROAN,CALMFACE,GROAN,BLUSH",
            "LAUGHTER,CALMFACE,SILENCE,CALMFACE",
            "SILENCE,CALMFACE,SILENCE,CALMFACE",
            "GRUNT,SMILE,SILENCE,BLUSH",
            "GROAN,SMILE,GROAN,BLUSH",
            "LAUGHTER,SMILE,GROAN,BLUSH",
            "SILENCE,SMILE,SILENCE,CALMFACE",
    })
    void reactToRoomState(NoiseReaction noiseReaction, FaceReaction faceReaction,
                          NoiseReaction expectedNoiseReaction, FaceReaction expectedFaceReaction) {
        RoomStateData roomStateData = new RoomStateData(0, 0, noiseReaction, faceReaction);
        ReactionsData resData = missBock.reactToRoomState(roomStateData);
        assertEquals(expectedFaceReaction, resData.getFaceReaction());
        assertEquals(expectedNoiseReaction, resData.getNoiseReaction());
    }

    @ParameterizedTest
    @CsvSource({
            "-100,false",
            "-10,false",
            "0,false",
            "5,false",
            "6,true",
            "100,true",
    })
    void isMissBockTurn(int levelOfEmotionality, boolean expectedTurned) {
        missBock.setLevelOfEmotionality(levelOfEmotionality);
        assertEquals(expectedTurned, missBock.isMissBockTurn());
    }
}