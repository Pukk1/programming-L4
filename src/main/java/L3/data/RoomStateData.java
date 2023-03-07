package L3.data;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

public class RoomStateData {
    private int numberOfCakes;
    private int startNumberOfCakes;
    @NotNull
    private NoiseReaction noiseReaction /*= Noise.SILENCE*/;
    @NotNull
    private FaceReaction faceReaction /*= FaceReaction.CALMFACE*/;

    public RoomStateData(int numberOfCakes, int startNumberOfCakes, @NotNull NoiseReaction noiseReaction, @NotNull FaceReaction faceReaction) {
        this.numberOfCakes = numberOfCakes;
        this.startNumberOfCakes = startNumberOfCakes;
        this.noiseReaction = noiseReaction;
        this.faceReaction = faceReaction;
    }

    public int getNumberOfCakes() {
        return numberOfCakes;
    }

    public int getStartNumberOfCakes() {
        return startNumberOfCakes;
    }

    public @NotNull NoiseReaction getNoiseReaction() {
        return noiseReaction;
    }

    public @NotNull FaceReaction getFaceReaction() {
        return faceReaction;
    }
}
